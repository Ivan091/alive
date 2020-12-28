package com.model.simulation.entities.alive.bot.genome.gene.conditional;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public class GenomeJump extends ConditionalGene {
    /**
     * @param initialKey Using as a parameter for conditional jump.
     */
    public GenomeJump(int initialKey) {
        super(initialKey);
        if (key == 0) {
            key = 1;
        }
    }

    @Override
    public Boolean run(Bot bot) {
        bot.getEnergy().incrementEnergyValue(Math.abs(key) / -2);
        bot.getGenome().incrementGeneIdx(key);
        return true;
    }

    @Override
    public Gene replicate() {
        return new GenomeJump(key);
    }

    @Override
    public String toString() {
        return "GenomeJump{" +
                "key=" + key +
                '}';
    }
}
