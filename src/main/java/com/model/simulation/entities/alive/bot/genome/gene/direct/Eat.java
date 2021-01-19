package com.model.simulation.entities.alive.bot.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public class Eat extends DirectGene {

    @Override
    public Boolean run(Bot bot) {

        bot.getObservedPos().ifPresent(pos -> {
            var eatenEntity = bot.getField().getCellsMatrix().pull(pos);
            if (eatenEntity instanceof Bot eatenBot) {
                if (!eatenBot.isFriendly(bot)) {
                    var receivingEnergy = eatenBot.getEnergy().getEnergyValue() >> 1;
                    bot.getEnergy().incrementEnergyValue(receivingEnergy);
                    if (receivingEnergy > 0) {
                        bot.getColor().incrementColor(100, -50, -50);
                    }
                }
            }
        });

        bot.getEnergy().incrementEnergyValue(-2);
        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Eat();
    }
}
