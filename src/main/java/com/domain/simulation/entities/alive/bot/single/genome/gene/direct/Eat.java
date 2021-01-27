package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.visitor.VisitorIsFriendlyBot;

public class Eat extends DirectGene {
    @Override
    public boolean run(Bot bot) {
        bot.observedPos().ifPresent(pos -> {
            var eatenEntity = bot.matrixEntities().pull(pos);

            if (new VisitorIsFriendlyBot(bot).response(eatenEntity)) {
                return;
            }

            var receivingEnergy = eatenEntity.energy().value() * 0.5;
            if (receivingEnergy > 0) {
                bot.energy().changeValue(v -> v + receivingEnergy);
                bot.repaint(bot.color().incrementValue(100, -50, -50));
            }
        });

        bot.energy().changeValue(v -> v - 10);
        bot.genome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {
        return new Eat();
    }
}
