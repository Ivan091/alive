package com.domain.simulation.entities.lifeless;

import com.domain.simulation.entities.EntityAbstract;
import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.position.Position;

public abstract class LifelessEntity extends EntityAbstract {

    private final Energy energy;

    public LifelessEntity(Position position, ColorEntity color, Energy energy) {
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
    public final Energy energy() {
        return energy;
    }
}
