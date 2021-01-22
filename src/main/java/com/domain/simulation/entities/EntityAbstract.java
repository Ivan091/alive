package com.domain.simulation.entities;

import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.position.Position;

public abstract class EntityAbstract implements Entity {

    protected Position position;
    protected ColorEntity color;

    public EntityAbstract(Position position, ColorEntity color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public void repaint(ColorEntity newColor) {
        color = newColor;
    }

    @Override
    public final Position position() {
        return position;
    }

    @Override
    public void relocate(Position newPos) {
        position = newPos;
    }

    @Override
    public ColorEntity color() {
        return color;
    }
}
