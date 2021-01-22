package com.domain.simulation;

import com.domain.simulation.entities.alive.bot.single.BotSingle;
import com.domain.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyAliveAlive;
import com.domain.simulation.entities.alive.bot.single.genome.GenomeBot;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.field.Field;

public class SimulationLive implements Simulation {

    private final Field field;

    public SimulationLive(Field field) {
        this.field = field;
    }

    public void start() {

        field.putEntity(new BotSingle(field, new PositionEntity(field.getWidth() / 2, field.getHeight() / 2),
                new EnergyAliveAlive(500), new BotLookDirection(2), GenomeBot.createFirstBotGenome()));
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
