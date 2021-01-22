package com.domain.simulation.entities.alive.bot.single;

import com.domain.simulation.entities.alive.bot.BotAbstract;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.direction.LookDirection;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.field.Field;

public class BotSingle extends BotAbstract {

    public BotSingle(Field field, Position position, EnergyMortal energy, LookDirection lookDirection, Genome genome) {
        super(field, position, energy, lookDirection, genome);
    }
}
