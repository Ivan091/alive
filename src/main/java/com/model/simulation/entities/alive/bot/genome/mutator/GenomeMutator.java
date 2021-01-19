package com.model.simulation.entities.alive.bot.genome.mutator;

import com.model.simulation.entities.alive.bot.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.GeneFactory;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.conditional.GenomeJumpFactory;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.conditional.RotatingGeneFactory;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.direct.*;

import java.util.Random;

public class GenomeMutator implements Mutator<Gene[]> {

    private final GeneFactory[] possibleGenes;

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

        var newGenes = new Gene[mutatingGenes.length];

        var mutatingIndex = rnd.nextInt(mutatingGenes.length);

        for (var i = 0; i < newGenes.length; ++i) {
            if (mutatingIndex == i) {
                newGenes[i] = generateRandomGene(newGenes.length);
            } else {
                newGenes[i] = mutatingGenes[i].replicate();
            }
        }

        return newGenes;
    }

    private Gene generateRandomGene(int genomeLength) {
        return possibleGenes[(rnd.nextInt(possibleGenes.length))].create(rnd.nextInt(), genomeLength);
    }
}
