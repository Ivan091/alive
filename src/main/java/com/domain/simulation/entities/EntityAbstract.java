package com.domain.simulation.entities;

import com.domain.simulation.entities.alive.qualities.color.Color;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.visitor.Visitor;

public abstract class EntityAbstract implements Entity {

    protected Position position;
    protected Color color;

    public EntityAbstract(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
