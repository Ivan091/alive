package alive.bot.genome.mutator;

import alive.WorldConstants;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.mutator.fabric.GeneFabric;
import alive.bot.genome.mutator.fabric.conditional.GenomeJumpFabric;
import alive.bot.genome.mutator.fabric.conditional.RotatingGeneFabric;
import alive.bot.genome.mutator.fabric.direct.*;

import java.util.Random;
import java.util.stream.IntStream;

public class GenomeMutator implements Mutator<Gene[]> {

    private final GeneFabric[] possibleGenes;

    private final double changeGenomeLengthProbability = 0.1;

    private final Random rnd = new Random();

    public GenomeMutator() {
        possibleGenes = new GeneFabric[]
                {
                        new PhotosynthesisGeneFabric(),
                        new GoGeneFabric(),
                        new EatGeneFabric(),
                        new RotatingGeneFabric(),
                        new GenomeJumpFabric(),
                };
    }

    @Override
    public Gene[] mutate(Gene[] mutatingGenes) {

        rnd.setSeed(System.currentTimeMillis());
        var newGenes = cloneGenes(mutatingGenes, generateNewGenesLength(mutatingGenes.length));

        var mutationsCount = rnd.nextInt(4) + 1;
        IntStream.range(0, mutationsCount)
                .forEach(i -> newGenes[rnd.nextInt(newGenes.length)] = generateRandomGene(newGenes.length));

        return newGenes;
    }

    private Gene[] cloneGenes(Gene[] mutatingGenes, int newGenesCount) {

        var newGenes = new Gene[newGenesCount];

        if (newGenesCount > mutatingGenes.length) {
            IntStream.range(0, mutatingGenes.length).forEach(i -> newGenes[i] = mutatingGenes[i].replicate());
            IntStream.range(mutatingGenes.length, newGenesCount)
                    .forEach(i -> newGenes[i] = generateRandomGene(newGenesCount));
        } else {
            IntStream.range(0, newGenesCount).forEach(i -> newGenes[i] = mutatingGenes[i].replicate());
        }
        return newGenes;
    }

    private int generateNewGenesLength(int mutatingGenesCount) {

        if (rnd.nextDouble() < changeGenomeLengthProbability) {
            int key;

            do {
                key = rnd.nextInt(mutatingGenesCount / 10 + 1) - mutatingGenesCount / 20;
            } while (Math.abs(key) < 1);

            if (mutatingGenesCount + key < WorldConstants.MIN_GENOME_LENGTH ||
                    mutatingGenesCount + key > WorldConstants.MAX_GENOME_LENGTH) {
                return mutatingGenesCount;
            }
            return mutatingGenesCount + key;
        }
        return mutatingGenesCount;
    }

    private Gene generateRandomGene(int genesCount) {
        return possibleGenes[(rnd.nextInt(possibleGenes.length))].create(rnd.nextInt(), genesCount);
    }
}
