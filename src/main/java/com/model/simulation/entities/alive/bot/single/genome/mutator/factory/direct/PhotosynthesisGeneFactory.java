package com.model.simulation.entities.alive.bot.single.genome.mutator.factory.direct;

import com.model.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.single.genome.gene.direct.Photosynthesis;
import com.model.simulation.entities.alive.bot.single.genome.mutator.factory.GeneFactory;

public class PhotosynthesisGeneFactory implements GeneFactory {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Photosynthesis();
    }
}
