package com.model.simulation.entities.alive.bot.genome.mutator.factory.direct;

import com.model.simulation.entities.alive.bot.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.genome.gene.direct.Go;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.GeneFactory;

public class GoGeneFactory implements GeneFactory {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Go();
    }
}
