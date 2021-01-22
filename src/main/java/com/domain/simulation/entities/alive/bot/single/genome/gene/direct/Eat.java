package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.visitor.VisitorFriendly;
import com.domain.simulation.entities.visitor.VisitorIsFriendlyBot;

public class Eat extends DirectGene {

    private static final VisitorFriendly visitorEntity = new VisitorIsFriendlyBot();

    @Override
    public boolean run(Bot bot) {
        bot.getObservedPos().ifPresent(pos -> {
            var eatenEntity = bot.getField().getCellsMatrix().pull(pos);

            visitorEntity.assign(bot);
            eatenEntity.accept(visitorEntity);
            if (visitorEntity.response()) {
                return;
            }

            var receivingEnergy = eatenEntity.getEnergy().getEnergyValue() >> 1;
            if (receivingEnergy > 0) {
                bot.getEnergy().incrementEnergyValue(receivingEnergy);
                bot.getColor().incrementColor(100, -50, -50);
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
