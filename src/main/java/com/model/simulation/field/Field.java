package com.model.simulation.field;

import com.model.simulation.entities.Entity;
import com.model.simulation.field.matrix.MatrixEntities;

public interface Field {

    void update();

    void putEntity(Entity puttingEntity);

    MatrixEntities getCellsMatrix();

    int aliveEntitiesCount();

    int getWidth();

    int getHeight();
}
