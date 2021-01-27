package com.domain.simulation.field;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.field.matrix.MatrixEntities;

public interface FieldMatrix {


    /**
     * Puts entity to {@link #cellsMatrix()} and to alive entities queue.
     *
     * @param entity put entity
     */
    void putEntity(Entity entity);

    MatrixEntities cellsMatrix();
}
