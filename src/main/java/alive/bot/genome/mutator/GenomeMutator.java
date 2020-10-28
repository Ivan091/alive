package alive.bot.genome.mutator;

import alive.Randomize;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.mutator.fabric.GeneFabric;
import alive.bot.genome.mutator.fabric.conditional.RotatingGeneFabric;
import alive.bot.genome.mutator.fabric.direct.EatGeneFabric;
import alive.bot.genome.mutator.fabric.direct.GoGeneFabric;
import alive.bot.genome.mutator.fabric.direct.PhotosynthesisGeneFabric;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenomeMutator implements Mutator<Gene[]> {

    private final List<GeneFabric> possibleGenes = new ArrayList<>();

    public GenomeMutator() {

        possibleGenes.add(new PhotosynthesisGeneFabric());
        possibleGenes.add(new RotatingGeneFabric());
        possibleGenes.add(new EatGeneFabric());
        possibleGenes.add(new GoGeneFabric());
    }

    @Override
    public Gene[] mutate(Gene[] mutatingItem, int mutationsCount) {

        if (mutationsCount < 1) {
            throw new IllegalArgumentException();
        }
        
        var mutatingIndexes = new HashSet<Integer>();
        for (var i = 0; i < mutationsCount; ++i) {
            mutatingIndexes.add(Randomize.nextInt(mutatingItem.length));
        }

        var newGenes = new Gene[mutatingItem.length];

        for (var i = 0; i < newGenes.length; ++i) {

            if (mutatingIndexes.contains(i)) {
                newGenes[i] = possibleGenes.get(Randomize.nextInt(possibleGenes.size()))
                        .create(Randomize.nextInt(mutatingItem.length));
            } else {
                newGenes[i] = mutatingItem[i].replicate();
            }
        }
        return newGenes;
    }
}
