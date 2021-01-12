package com.model.simulation.entities.alive.bot.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public class Eat extends DirectGene {

    @Override
    public Boolean run(Bot bot) {

        bot.getLookingPos().ifPresent(pos -> {
            var matrixEntities = bot.getField().getCellsMatrix();
            var eatingEntity = matrixEntities.pull(pos);
            if (eatingEntity instanceof Bot eatingBot) {
                if (!eatingBot.getGenome().isFriendly(bot.getGenome())) {
                    var receivingEnergy = eatingBot.getEnergy().getEnergyValue() >> 1;
                    if (receivingEnergy > 0) {
                        bot.getEnergy().incrementEnergyValue(receivingEnergy);
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
