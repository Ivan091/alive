package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

public class Go extends DirectGene {

    @Override
    public boolean run(Bot bot) {

        bot.getObservedPos().ifPresent(newPos -> {
            var cells = bot.getField().getCellsMatrix();
            if (cells.isEmpty(newPos)) {
                cells.pull(bot.getPosition());
                bot.getPosition().copyOf(newPos);
                cells.put(bot);
            }
        });

        bot.getEnergy().incrementEnergyValue(-2);
        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Go();
    }
}
