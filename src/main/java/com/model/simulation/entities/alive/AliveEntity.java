package com.model.simulation.entities.alive;

import com.model.simulation.entities.EntityAbstract;
import com.model.simulation.entities.alive.bot.energy.EnergyAlive;
import com.model.simulation.entities.qualities.position.Position;

public abstract class AliveEntity extends EntityAbstract implements Alive {

    protected final EnergyAlive energy;

    public AliveEntity(Position position, EnergyAlive energy) {
        super(position);
        this.energy = energy;
    }

    @Override
    public final EnergyAlive getEnergy() {
        return energy;
    }
}
