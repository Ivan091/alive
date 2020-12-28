package com.model.simulation.field;

import com.model.simulation.entities.Entity;
import com.model.simulation.field.matrix.MatrixEntities;
import com.model.simulation.field.matrix.MatrixLiveEntities;

import java.util.*;

public class FieldLive implements Field {

    private final MatrixEntities matrixEntities;

    private final List<Entity> aliveEntities;

    private final Queue<Entity> entitiesPutThisTurn;

    public FieldLive(int width, int height) {

        matrixEntities = new MatrixLiveEntities(height, width);
        aliveEntities = new LinkedList<>();
        entitiesPutThisTurn = new LinkedList<>();
    }

    @Override
    public void update() {

        var aliveEntitiesIt = aliveEntities.iterator();
        while (aliveEntitiesIt.hasNext()) {

            var curEntity = aliveEntitiesIt.next();

            if (curEntity.isAlive() && matrixEntities.isInMatrix(curEntity)) {
                curEntity.makeAMove();
            } else {
                aliveEntitiesIt.remove();
            }
        }

        while (!entitiesPutThisTurn.isEmpty()) {
            var curEntity = entitiesPutThisTurn.poll();

            if (curEntity.isAlive() && matrixEntities.isInMatrix(curEntity)) {
                curEntity.makeAMove();
                aliveEntities.add(curEntity);
            }
        }
    }

    @Override
    public void putEntity(Entity puttingEntity) {

        matrixEntities.put(puttingEntity);
        entitiesPutThisTurn.add(puttingEntity);
    }

    @Override
    public MatrixEntities getCellsMatrix() {

        return matrixEntities;
    }

    @Override
    public int aliveEntitiesCount() {
        return aliveEntities.size() + entitiesPutThisTurn.size();
    }

    @Override
    public int getWidth() {

        return matrixEntities.getWidth();
    }

    @Override
    public int getHeight() {

        return matrixEntities.getHeight();
    }
}
