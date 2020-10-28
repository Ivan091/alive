package alive.bot.genome;

import alive.Randomize;
import alive.WorldConstants;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Photosynthesis;
import alive.bot.genome.mutator.GenomeMutator;
import alive.bot.genome.mutator.Mutator;

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

        this.genes = genes;
    }

    @Override
    public Gene getCurrentGen() {

        return genes[currentGenIdx];
    }

    @Override
    public void incrementGenIdx(int countOfGenes) {

        currentGenIdx = (currentGenIdx + countOfGenes) % genes.length;

        if (currentGenIdx < 0) {
            currentGenIdx += genes.length;
        }
    }

    @Override
    public Genome replicate() {

        if (Randomize.nextFloat() < 0.25) {
            return new BotGenome(genomeMutator.mutate(genes, Randomize.nextInt(1, 4)));
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
