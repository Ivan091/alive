package com.domain.simulation.entities.alive.bot.single.genome.gene.conditional;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

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
    public boolean run(Bot bot) {
        bot.energy().changeValue(v -> v - (Math.abs(key) >> 1));
        bot.genome().incrementGeneIdx(key);
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
