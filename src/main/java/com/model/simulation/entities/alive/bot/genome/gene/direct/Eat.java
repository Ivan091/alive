package com.model.simulation.entities.alive.bot.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public class Eat extends DirectGene {

    @Override
    public Boolean run(Bot bot) {

        bot.getLookingPos().ifPresent(pos -> {

            var matrixEntities = bot.getField().getCellsMatrix();
            var eatingEntity = matrixEntities.pull(pos);
            bot.getEnergy().incrementEnergyValue(eatingEntity.getEnergy().getEnergyValue() >> 1);
            bot.getColor().changeColor(100, -50, -50);
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
