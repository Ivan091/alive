package com.model.simulation.entities.lifeless;

import com.model.simulation.entities.EntityAbstract;
import com.model.simulation.entities.qualities.energy.Energy;
import com.model.simulation.entities.qualities.position.Position;

public abstract class LifelessEntity extends EntityAbstract {

    private final Energy energy;

    public LifelessEntity(Position position, Energy energy) {
        super(position);
        this.energy = energy;
    }

    @Override
    public final boolean isAlive() {
        return false;
    }

    @Override
    public final Energy getEnergy() {
        return energy;
    }

    @Override
    public final void makeAMove() {
    }
}
