package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

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
