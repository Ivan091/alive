package com.model.simulation.entities.alive;

import com.model.simulation.entities.EntityAbstract;
import com.model.simulation.entities.alive.bot.energy.EnergyAlive;
import com.model.simulation.entities.qualities.color.Color;
import com.model.simulation.entities.qualities.position.Position;

public abstract class AliveEntity extends EntityAbstract implements Alive {

    protected final EnergyAlive energy;

    public AliveEntity(Position position, EnergyAlive energy, Color color) {
        super(position, color);
        this.energy = energy;
    }

    @Override
    public final EnergyAlive getEnergy() {
        return energy;
    }
}
