package com.domain.simulation.entities.alive.bot.single.genome;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.GenomeMutator;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.Mutator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Random;

public class GenomeBot implements Genome {

    private static final int maxDifferencesToBeFriendly = (int) (WorldConstants.GENOME_LENGTH * 0.25);

    private static final Mutator<Gene[]> genomeMutator = new GenomeMutator();
    private final Gene[] genes;
    private int currentGeneIdx;

    public GenomeBot(Gene[] genes) {

        if (genes.length < 1) {
            throw new IllegalArgumentException("genome length was less than 1");
        }

        this.genes = genes;
    }

    @Override
    public void incrementGeneIdx(int countOfGenes) {

        currentGeneIdx = (currentGeneIdx + countOfGenes) % genes.length;

        if (currentGeneIdx < 0) {
            currentGeneIdx += genes.length;
        }
    }

    @Override
    public boolean runCurrentGene(Bot bot) {
        return genes[currentGeneIdx].run(bot);
    }

    @Override
    public boolean isFriendly(Genome genome) {
        var differencesCount = 0;
        for (var i = 0; i < genes.length; ++i) {
            if (!genes[i].equals(genome.getGenes()[i])) {
                ++differencesCount;
            }
            if (differencesCount > maxDifferencesToBeFriendly) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Gene[] getGenes() {
        return genes;
    }

    @Override
    public int length() {
        return genes.length;
    }

    @Override
    public Genome replicate() {

        if (new Random().nextFloat() < WorldConstants.MUTATION_PROBABILITY) {
            return new GenomeBot(genomeMutator.mutate(genes));
        }
        return createExactCopyOfGenome();
    }

    @JsonIgnore
    private Genome createExactCopyOfGenome() {

        var newGenes = new Gene[genes.length];

        for (var i = 0; i < newGenes.length; ++i) {
            newGenes[i] = this.genes[i].replicate();
        }

        return new GenomeBot(newGenes);
    }
}
