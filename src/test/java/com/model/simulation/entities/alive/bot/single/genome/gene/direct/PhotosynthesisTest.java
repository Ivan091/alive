package com.model.simulation.entities.alive.bot.single.genome.gene.direct;

import com.model.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.model.simulation.entities.alive.bot.single.genome.mutator.factory.direct.PhotosynthesisGeneFactory;

class PhotosynthesisTest extends GeneTest {

    public PhotosynthesisTest() {
        super(new PhotosynthesisGeneFactory().create(0, 0));
    }
}