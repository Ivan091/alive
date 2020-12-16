package alive.bot.genome;

import alive.WorldConstants;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Photosynthesis;
import alive.bot.genome.mutator.GenomeMutator;
import alive.bot.genome.mutator.Mutator;
import alive.bot.model.Bot;

import java.util.Random;
import java.util.stream.IntStream;

public class BotGenome implements Genome {

    private final Gene[] genes;

    private int currentGeneIdx;

    private static final Mutator<Gene[]> genomeMutator = new GenomeMutator();

    public static Genome createFirstBotGenome() {

        var genes = new Gene[WorldConstants.START_GENOME_LENGTH];

        IntStream.range(0, genes.length).forEach(i -> genes[i] = new Photosynthesis());

        return new BotGenome(genes);
    }

    public BotGenome(Gene[] genes) {

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
    public int length() {
        return genes.length;
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
