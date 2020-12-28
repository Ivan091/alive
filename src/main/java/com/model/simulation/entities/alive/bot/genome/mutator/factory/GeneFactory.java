package com.model.simulation.entities.alive.bot.genome.mutator.factory;

import com.model.simulation.entities.alive.bot.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.genome.gene.conditional.ConditionalGene;

/**
 * Factory for {@link Gene}.
 */
public interface GeneFactory {

    /**
     * Creates new gene.
     *
     * @param key          necessary to create {@link ConditionalGene}.
     * @param genomeLength length of genome of current bot.
     * @return created gene.
     */
    Gene create(int key, int genomeLength);
}
