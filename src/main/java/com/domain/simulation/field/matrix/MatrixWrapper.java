package com.domain.simulation.field.matrix;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.field.Field;

public class MatrixWrapper extends MatrixLiveEntities {

    private final Field field;

    public MatrixWrapper(int height, int width, Field field) {
        super(height, width);
        this.field = field;
    }

    @Override
    public Entity put(Entity newEntity) {
        var oldEntity = super.get(newEntity.position());
        field.putEntity(newEntity);
        return oldEntity;
    }
}
