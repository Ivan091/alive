package alive.bot.genome;

import alive.Randomize;
import alive.WorldConstants;
import alive.bot.genome.fabric.GeneFabric;
import alive.bot.genome.fabric.conditional.RotatingGeneFabric;
import alive.bot.genome.fabric.direct.EatGeneFabric;
import alive.bot.genome.fabric.direct.GoGeneFabric;
import alive.bot.genome.fabric.direct.PhotosynthesisGeneFabric;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Photosynthesis;

import java.util.ArrayList;
import java.util.List;

public class BotGenome implements Genome {

    private final Gene[] genes;

    private int currentGenIdx;

    private static final List<GeneFabric> possibleGenes = new ArrayList<>();

    static {
        possibleGenes.add(new PhotosynthesisGeneFabric());
        possibleGenes.add(new RotatingGeneFabric());
        possibleGenes.add(new EatGeneFabric());
        possibleGenes.add(new GoGeneFabric());
    }

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
            return getMutatedGenome();
        }
        return getExactCopyOfGenome();
    }

    private Genome getMutatedGenome() {

        var mutatingIdx = Randomize.nextInt(genes.length);

        var newGenes = new Gene[WorldConstants.GENOME_LENGTH];

        for (var i = 0; i < newGenes.length; ++i) {

            if (i == mutatingIdx) {
                newGenes[i] = possibleGenes.get(Randomize.nextInt(possibleGenes.size()))
                        .create(Randomize.nextInt(genes.length));
            } else {
                newGenes[i] = this.genes[i].replicate();
            }
        }

        return new BotGenome(newGenes);
    }

    private Genome getExactCopyOfGenome() {

        var newGenes = new Gene[WorldConstants.GENOME_LENGTH];

        for (var i = 0; i < newGenes.length; ++i) {
            newGenes[i] = this.genes[i].replicate();
        }

        return new BotGenome(newGenes);
    }
}
