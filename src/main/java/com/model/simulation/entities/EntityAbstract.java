package com.model.simulation.entities;

import com.model.simulation.entities.alive.qualities.color.Color;
import com.model.simulation.entities.alive.qualities.position.Position;

public abstract class EntityAbstract implements Entity {

    protected Position position;

    protected Color color;

    public EntityAbstract(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public final Position getPosition() {
        return position;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
