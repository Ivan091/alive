package alive.bot.genome.mutator;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.mutator.fabric.GeneFabric;
import alive.bot.genome.mutator.fabric.conditional.RotatingGeneFabric;
import alive.bot.genome.mutator.fabric.direct.*;

import java.util.HashSet;
import java.util.Random;

public class GenomeMutator implements Mutator<Gene[]> {

    private final GeneFabric[] possibleGenes;

    public GenomeMutator() {
        possibleGenes = new GeneFabric[]{
                new PhotosynthesisGeneFabric(),
                new RotatingGeneFabric(),
                new GoGeneFabric(),
                new EatGeneFabric(),
        };
    }

    private final Random rnd = new Random();

    @Override
    public Gene[] mutate(Gene[] mutatingItem) {

        rnd.setSeed(System.currentTimeMillis());

        var mutationsCount = rnd.nextInt(3) + 1;

        var mutatingIndexes = new HashSet<Integer>();
        for (var i = 0; i < mutationsCount; ++i) {
            mutatingIndexes.add(rnd.nextInt(mutatingItem.length));
        }

        var newGenes = new Gene[mutatingItem.length];

        for (var i = 0; i < newGenes.length; ++i) {

            if (mutatingIndexes.contains(i)) {
                newGenes[i] = possibleGenes[(rnd.nextInt(possibleGenes.length))]
                        .create(rnd.nextInt());
            } else {
                newGenes[i] = mutatingItem[i].replicate();
            }
        }
        return newGenes;
    }
}
