package com.model.simulation.entities.alive.bot.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public class Go extends DirectGene {

    @Override
    public Boolean run(Bot bot) {

        bot.getLookingPos().ifPresent(newPos -> {
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
