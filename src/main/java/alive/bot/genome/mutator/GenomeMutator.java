package alive.bot.genome.mutator;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.mutator.fabric.GeneFabric;
import alive.bot.genome.mutator.fabric.conditional.RotatingGeneFabric;
import alive.bot.genome.mutator.fabric.direct.*;

import java.util.*;

public class GenomeMutator implements Mutator<Gene[]> {

    private final List<GeneFabric> possibleGenes = new ArrayList<>();

    private final Random rnd = new Random();

    public GenomeMutator() {

        possibleGenes.add(new PhotosynthesisGeneFabric());
        possibleGenes.add(new RotatingGeneFabric());
        possibleGenes.add(new GoGeneFabric());
        possibleGenes.add(new EatGeneFabric());
    }

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
                newGenes[i] = possibleGenes.get(rnd.nextInt(possibleGenes.size()))
                        .create(rnd.nextInt(mutatingItem.length));
            } else {
                newGenes[i] = mutatingItem[i].replicate();
            }
        }
        return newGenes;
    }
}
