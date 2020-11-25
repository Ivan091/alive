package alive.bot.genome;

import alive.WorldConstants;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Photosynthesis;
import alive.bot.genome.mutator.GenomeMutator;
import alive.bot.genome.mutator.Mutator;

import java.util.Random;

public class BotGenome implements Genome {

    private final Gene[] genes;

    private int currentGenIdx;

    private static final Mutator<Gene[]> genomeMutator = new GenomeMutator();


    public BotGenome() {

        genes = new Gene[WorldConstants.GENOME_LENGTH];

        for (var i = 0; i < genes.length; ++i) {
            genes[i] = new Photosynthesis();
        }
    }

    public BotGenome(Gene[] genes) {

        if (genes.length < 1) {
            throw new IllegalArgumentException("genome length was less than 1");
        }

        this.genes = genes;
    }

    @Override
    public Gene getCurrentGene() {

        return genes[currentGenIdx];
    }

    @Override
    public void incrementGeneIdx(int countOfGenes) {

        currentGenIdx = (currentGenIdx + countOfGenes) % genes.length;

        if (currentGenIdx < 0) {
            currentGenIdx += genes.length;
        }
    }

    @Override
    public Genome replicate() {

        if (new Random().nextFloat() < WorldConstants.MUTATION_PROBABILITY) {
            return new BotGenome(genomeMutator.mutate(genes));
        }
        return getExactCopyOfGenome();
    }

    private Genome getExactCopyOfGenome() {

        var newGenes = new Gene[genes.length];

        for (var i = 0; i < newGenes.length; ++i) {
            newGenes[i] = this.genes[i].replicate();
        }

        return new BotGenome(newGenes);
    }
}
