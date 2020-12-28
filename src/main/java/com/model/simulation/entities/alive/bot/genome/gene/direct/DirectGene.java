package com.model.simulation.entities.alive.bot.genome.gene.direct;

import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public abstract class DirectGene implements Gene {

    @Override
    public boolean equals(Object obj) {

        return obj.getClass() == this.getClass();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
