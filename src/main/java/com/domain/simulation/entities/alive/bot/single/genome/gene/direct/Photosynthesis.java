package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

public class Photosynthesis extends DirectGene {

    @Override
    public boolean run(Bot bot) {

        bot.energy().incrementValue(25);
        bot.genome().incrementGeneIdx(1);
        bot.repaint(bot.color().incrementValue(-25, 50, -25));
        return false;
    }

    @Override
    public Gene replicate() {

        return new Photosynthesis();
    }
}