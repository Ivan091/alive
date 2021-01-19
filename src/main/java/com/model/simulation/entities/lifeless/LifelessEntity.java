package com.model.simulation.entities.lifeless;

import com.model.simulation.entities.EntityAbstract;
import com.model.simulation.entities.alive.qualities.color.Color;
import com.model.simulation.entities.alive.qualities.energy.Energy;
import com.model.simulation.entities.alive.qualities.position.Position;

public abstract class LifelessEntity extends EntityAbstract {

    private final Energy energy;

    public LifelessEntity(Position position, Color color, Energy energy) {
        super(position, color);
        this.energy = energy;
    }

    @Override
    public final void makeAMove() {
    }

    @Override
    public final boolean isAlive() {
        return false;
    }

    @Override
    public final Energy getEnergy() {
        return energy;
    }
}
