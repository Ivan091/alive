package com.domain.simulation.entities.alive.bot.single.genome.gene.conditional;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

public class Rotating extends ConditionalGene {

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public Rotating(int key) {
        super(key);
    }

    @Override
    public boolean run(Bot bot) {

        bot.lookDirection().rotate(key);


        bot.energy().changeValue(v -> v - 4 * Math.abs(key));
        bot.genome().incrementGeneIdx(1);
        return true;
    }

    @Override
    public Gene replicate() {

        return new Rotating(key);
    }

    @Override
    public String toString() {
        return "Rotating{" +
                "key=" + key +
                '}';
    }
}
