package com.domain.simulation;

import com.domain.simulation.entities.alive.bot.single.BotSingle;
import com.domain.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyAliveMortal;
import com.domain.simulation.entities.alive.bot.single.genome.GenomeBuilder;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.field.Field;

public class SimulationLive implements Simulation {

    private final Field field;

    public SimulationLive(Field field) {
        this.field = field;
    }

    public void start() {
        field.putEntity(new BotSingle(field, new PositionEntity(field.width() / 2, field.height() / 2),
                new EnergyAliveMortal(500), new BotLookDirection(2), new GenomeBuilder().buildDefault()));
    }

    @Override
    public void nextMove() {
        field.update();
    }

    @Override
    public Field getField() {
        return field;
    }
}
