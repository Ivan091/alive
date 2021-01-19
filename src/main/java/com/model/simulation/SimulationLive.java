package com.model.simulation;

import com.model.simulation.entities.alive.bot.single.BotSingle;
import com.model.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.model.simulation.entities.alive.bot.single.energy.EnergyAliveAlive;
import com.model.simulation.entities.alive.bot.single.genome.BotGenome;
import com.model.simulation.entities.alive.qualities.position.PositionEntity;
import com.model.simulation.field.Field;


public class SimulationLive implements Simulation {

    private final Field field;

    public SimulationLive(Field field) {
        this.field = field;
    }

    public void start() {

        field.putEntity(new BotSingle(field, new PositionEntity(0, 0),
                new EnergyAliveAlive(500), new BotLookDirection(2), BotGenome.createFirstBotGenome()));
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
