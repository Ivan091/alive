package com.model.simulation.entities;

import com.model.simulation.entities.qualities.position.Position;

public abstract class EntityAbstract implements Entity {

    protected Position position;

    public EntityAbstract(Position position) {
        this.position = position;
    }

    @Override
    public final Position getPosition() {
        return position;
    }
}
