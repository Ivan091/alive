package com.domain.simulation.field;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.field.matrix.MatrixEntities;
import com.domain.simulation.field.matrix.MatrixLiveEntities;

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

    /**
     * Calls {@link Entity#makeAMove()} on each object from {@link #aliveEntities}
     * then from {@link #entitiesPutThisTurn}. If entity is dead or not in {@link #matrixEntities}
     * it is removed.
     */
    @Override
    public synchronized void update() {

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

    /**
     * Puts entity into {@link #matrixEntities} and pushes it in {@link #entitiesPutThisTurn}
     *
     * @param entity new entity
     */
    @Override
    public void putEntity(Entity entity) {
        matrixEntities.put(entity);
        entitiesPutThisTurn.add(entity);
    }

    @Override
    public MatrixEntities cellsMatrix() {

        return matrixEntities;
    }

    @Override
    public int aliveEntitiesCount() {
        return aliveEntities.size() + entitiesPutThisTurn.size();
    }

    @Override
    public int width() {
        return matrixEntities.getWidth();
    }

    @Override
    public int height() {

        return matrixEntities.getHeight();
    }
}
