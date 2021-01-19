package com.model.simulation.entities.alive.bot.single.genome;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.simulation.WorldConstants;
import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.single.genome.gene.direct.Photosynthesis;
import com.model.simulation.entities.alive.bot.single.genome.mutator.GenomeMutator;
import com.model.simulation.entities.alive.bot.single.genome.mutator.Mutator;

import java.util.Random;
import java.util.stream.IntStream;

public class BotGenome implements Genome {

    private static final int maxDifferencesToBeFriendly = 2;

    private static final Mutator<Gene[]> genomeMutator = new GenomeMutator();
    private final Gene[] genes;
    private int currentGeneIdx;

    public BotGenome(Gene[] genes) {

        if (genes.length < 1) {
            throw new IllegalArgumentException("genome length was less than 1");
        }

        this.genes = genes;
    }

    public static Genome createFirstBotGenome() {

        var genes = new Gene[WorldConstants.GENOME_LENGTH];

        IntStream.range(0, genes.length).forEach(i -> genes[i] = new Photosynthesis());

        return new BotGenome(genes);
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
            return new BotGenome(genomeMutator.mutate(genes));
        }
        return createExactCopyOfGenome();
    }

    @JsonIgnore
    private Genome createExactCopyOfGenome() {

        var newGenes = new Gene[genes.length];

        for (var i = 0; i < newGenes.length; ++i) {
            newGenes[i] = this.genes[i].replicate();
        }

        return new BotGenome(newGenes);
    }
}
