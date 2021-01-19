package com.model.simulation.entities.alive.bot.single.genome;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.single.genome.gene.Gene;

public interface Genome extends Replicable<Genome> {

    /**
     * Genome is infinite looped sequence of genes,
     * so the index cannot be out of range.
     *
     * @param increment can be any negative or positive int.
     */
    void incrementGeneIdx(int increment);

    boolean runCurrentGene(Bot bot);

    boolean isFriendly(Genome genome);

    Gene[] getGenes();

    int length();
}
