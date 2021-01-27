package com.domain.simulation.field;

import com.domain.simulation.entities.Entity;

public interface Field extends FieldMatrix {

    /**
     * Calls {@link Entity#makeAMove()} on each alive entity.
     */
    void update();

    int aliveEntitiesCount();

    int width();

    int height();
}
