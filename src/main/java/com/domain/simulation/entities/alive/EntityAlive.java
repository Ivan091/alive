package com.domain.simulation.entities.alive;

import com.domain.simulation.entities.EntityAbstract;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;
import com.domain.simulation.entities.alive.qualities.color.Color;
import com.domain.simulation.entities.alive.qualities.position.Position;

public abstract class EntityAlive extends EntityAbstract implements Alive {

    protected final EnergyMortal energy;

    public EntityAlive(Position position, EnergyMortal energy, Color color) {
        super(position, color);
        this.energy = energy;
    }

    @Override
    public final EnergyMortal getEnergy() {
        return energy;
    }
}
