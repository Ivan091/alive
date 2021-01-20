package com.domain.simulation.entities.alive;

import com.domain.simulation.entities.EntityAbstract;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyAlive;
import com.domain.simulation.entities.alive.qualities.color.Color;
import com.domain.simulation.entities.alive.qualities.position.Position;

public abstract class EntityAlive extends EntityAbstract implements Alive {

    protected final EnergyAlive energy;

    public EntityAlive(Position position, EnergyAlive energy, Color color) {
        super(position, color);
        this.energy = energy;
    }

    @Override
    public final EnergyAlive getEnergy() {
        return energy;
    }
}
