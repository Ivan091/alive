package com.model.simulation.entities.alive.bot.genome.mutator;

import com.model.simulation.WorldConstants;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.GeneFactory;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.conditional.GenomeJumpFactory;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.conditional.RotatingGeneFactory;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.direct.*;

import java.util.Random;
import java.util.stream.IntStream;

public class GenomeMutator implements Mutator<Gene[]> {

    private final GeneFactory[] possibleGenes;

    private final double changingGenomeLengthProbability = 0.1;

    private final int maxGenomeLengthChanging = 3;

    private final int maxMutationsCount = 4;

    private final Random rnd = new Random();

    public GenomeMutator() {
        possibleGenes = new GeneFactory[]
                {
                        // Direct.
                        new PhotosynthesisGeneFactory(),
                        new GoGeneFactory(),
                        new EatGeneFactory(),

                        // Conditional.
                        new RotatingGeneFactory(),
                        new GenomeJumpFactory(),
                };
    }

    @Override
    public Gene[] mutate(Gene[] mutatingGenes) {

        rnd.setSeed(System.currentTimeMillis());

        var newGenes = replicateGenes(mutatingGenes, generateNewGenomeLength(mutatingGenes.length));

        var mutationsCount = getRandomInt(1, maxMutationsCount);
        IntStream.range(0, mutationsCount)
                .forEach(i -> newGenes[rnd.nextInt(newGenes.length)] = generateRandomGene(newGenes.length));

        return newGenes;
    }

    private Gene[] replicateGenes(Gene[] mutatingGenes, int newGenomeLength) {

        var newGenes = new Gene[newGenomeLength];

        if (newGenomeLength > mutatingGenes.length) {
            IntStream.range(0, mutatingGenes.length).forEach(i -> newGenes[i] = mutatingGenes[i].replicate());
            IntStream.range(mutatingGenes.length, newGenomeLength)
                    .forEach(i -> newGenes[i] = generateRandomGene(newGenomeLength));
        } else {
            IntStream.range(0, newGenomeLength).forEach(i -> newGenes[i] = mutatingGenes[i].replicate());
        }
        return newGenes;
    }

    private int generateNewGenomeLength(int currentGenomeLength) {

        if (rnd.nextDouble() < changingGenomeLengthProbability) {
            var genomeLengthIncrement = generateGenomeLengthIncrement();

            if (isGenomeLengthPossible(currentGenomeLength + genomeLengthIncrement)) {
                return currentGenomeLength + genomeLengthIncrement;
            }
        }
        return currentGenomeLength;
    }

    private int getRandomInt(int lowerBound, int higherBound) {

        return rnd.nextInt(higherBound - lowerBound + 1) + lowerBound;
    }

    private Gene generateRandomGene(int genomeLength) {
        return possibleGenes[(rnd.nextInt(possibleGenes.length))].create(rnd.nextInt(), genomeLength);
    }

    private int generateGenomeLengthIncrement() {
        int genomeLengthIncrement;
        do {
            genomeLengthIncrement = getRandomInt(-maxGenomeLengthChanging, maxGenomeLengthChanging);
        } while (genomeLengthIncrement == 0);
        return genomeLengthIncrement;
    }

    private boolean isGenomeLengthPossible(int genesCount) {
        return genesCount > WorldConstants.MIN_GENOME_LENGTH && genesCount < WorldConstants.MAX_GENOME_LENGTH;
    }
}
