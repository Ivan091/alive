package com.model.simulation.field;

import com.model.simulation.entities.Entity;
import com.model.simulation.field.matrix.MatrixEntities;

public interface Field {

    /**
     * Calls {@link Entity#makeAMove()} on each alive entity.
     */
    void update();

    void putEntity(Entity entity);

    MatrixEntities getCellsMatrix();

    int aliveEntitiesCount();

    int getWidth();

    int getHeight();
}
