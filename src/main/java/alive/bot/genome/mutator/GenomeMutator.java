package alive.bot.genome.mutator;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.mutator.fabric.GeneFabric;
import alive.bot.genome.mutator.fabric.conditional.RotatingGeneFabric;
import alive.bot.genome.mutator.fabric.direct.*;

import java.util.*;

public class GenomeMutator implements Mutator<Gene[]> {

    private final List<GeneFabric> possibleGenes = new ArrayList<>();

    public GenomeMutator() {

        possibleGenes.add(new PhotosynthesisGeneFabric());
        possibleGenes.add(new RotatingGeneFabric());
        possibleGenes.add(new GoGeneFabric());
        possibleGenes.add(new EatGeneFabric());
    }

    @Override
    public Gene[] mutate(Gene[] mutatingItem) {

        var rand = new Random();
        var mutationsCount = rand.nextInt(4) + 1;

        var mutatingIndexes = new HashSet<Integer>();
        for (var i = 0; i < mutationsCount; ++i) {
            mutatingIndexes.add(rand.nextInt(mutatingItem.length));
        }

        var newGenes = new Gene[mutatingItem.length];

        for (var i = 0; i < newGenes.length; ++i) {

            if (mutatingIndexes.contains(i)) {
                newGenes[i] = possibleGenes.get(rand.nextInt(possibleGenes.size()))
                        .create(rand.nextInt(mutatingItem.length));
            } else {
                newGenes[i] = mutatingItem[i].replicate();
            }
        }
        return newGenes;
    }
}
