package com.model.simulation.entities.lifeless;

import com.model.simulation.entities.qualities.color.ColorEntity;
import com.model.simulation.entities.qualities.energy.Energy;
import com.model.simulation.entities.qualities.position.Position;

public class EmptyEntity extends LifelessEntity implements Empty {

    public EmptyEntity(Position position, Energy energy) {
        super(position, new ColorEntity(0, 0, 0), energy);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }
}