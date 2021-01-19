package com.model.simulation.entities.alive.bot.single;

import com.model.simulation.entities.alive.bot.BotAbstract;
import com.model.simulation.entities.alive.bot.single.energy.EnergyAlive;
import com.model.simulation.entities.alive.bot.single.genome.Genome;
import com.model.simulation.entities.alive.qualities.direction.LookDirection;
import com.model.simulation.entities.alive.qualities.position.Position;
import com.model.simulation.field.Field;

public class BotSingle extends BotAbstract {

    public BotSingle(Field field, Position position, EnergyAlive energy, LookDirection lookDirection, Genome genome) {
        super(field, position, energy, lookDirection, genome);
    }
}
