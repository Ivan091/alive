package com.domain.simulation.entities.lifeless;

import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.visitor.Visitor;

public class EmptyEntity extends LifelessEntity implements Empty {

    public EmptyEntity(Position position, Energy energy) {
        super(position, new ColorEntity(0, 0, 0), energy);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}