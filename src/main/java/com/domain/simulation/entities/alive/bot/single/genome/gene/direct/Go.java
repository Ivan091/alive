package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

public class Go extends DirectGene {

    @Override
    public boolean run(Bot bot) {

        bot.observedPos().ifPresent(newPos -> {
            var cells = bot.field().cellsMatrix();
            if (cells.isEmpty(newPos)) {
                cells.pull(bot.position());
                bot.relocate(newPos);
                cells.put(bot);
            }
        });

        bot.energy().changeValue(v -> v - 50);
        bot.genome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Go();
    }
}
