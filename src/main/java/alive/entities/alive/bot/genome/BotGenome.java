package alive.entities.alive.bot.genome;

import alive.WorldConstants;
import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.direct.Photosynthesis;
import alive.entities.alive.bot.genome.mutator.GenomeMutator;
import alive.entities.alive.bot.genome.mutator.Mutator;

import java.util.Random;
import java.util.stream.IntStream;

public class BotGenome implements Genome {

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

        var genes = new Gene[WorldConstants.START_GENOME_LENGTH];

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
