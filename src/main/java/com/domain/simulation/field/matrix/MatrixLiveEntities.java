package com.domain.simulation.field.matrix;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.entities.lifeless.Empty;
import com.domain.simulation.entities.lifeless.EmptyEntity;

import java.util.*;

public class MatrixLiveEntities implements MatrixEntities {

    private final Entity[][] entities;

    public MatrixLiveEntities(int height, int width) {

        entities = new Entity[height][width];
        for (var i = 0; i < height; ++i) {
            for (var j = 0; j < width; ++j) {
                var pos = createPositionInside(j, i);
                if (pos.isPresent()) {
                    entities[i][j] = new EmptyEntity(pos.get(), new EnergyEntity(0));
                }
            }
        }
    }

    @Override
    public Optional<Position> createPositionInside(int x, int y) {

        return makePositionToBeInside(new PositionEntity(x, y));
    }

    @Override
    public Optional<Position> makePositionToBeInside(Position pos) {

        var y = pos.y();
        if (y < 0 || y >= getHeight()) {
            return Optional.empty();
        }

        var x = pos.x();
        if (x < 0 || x >= getWidth()) {
            x %= getWidth();
            if (x < 0) {
                x = x + getWidth();
            }
            pos = new PositionEntity(x, y);
        }

        return Optional.of(pos);
    }

    @Override
    public List<Position> findEmptyPositionsAround(Position pos) {
        var positionsAround = new ArrayList<Position>(8);

        var x = pos.x();
        var y = pos.y();

        for (var i = x - 1; i <= x + 1; ++i) {
            for (var j = y - 1; j <= y + 1; ++j) {
                if (i != x || j != y) {
                    createPositionInside(i, j).ifPresent(foundPos -> {
                        if (isEmpty(foundPos)) {
                            positionsAround.add(foundPos);
                        }
                    });
                }
            }
        }

        return positionsAround;
    }

    @Override
    public Entity get(Position pos) {
        return entities[pos.y()][pos.x()];
    }

    @Override
    public Entity put(Entity newEntity) {
        var pos = newEntity.position();
        var previousEntity = get(pos);
        entities[pos.y()][pos.x()] = newEntity;
        return previousEntity;
    }

    @Override
    public Entity pull(Position pos) {
        if (!isEmpty(pos)) {
            return put(new EmptyEntity(new PositionEntity(pos), new EnergyEntity(0)));
        }
        return get(pos);
    }

    @Override
    public boolean isEmpty(Position pos) {

        return get(pos) instanceof Empty;
    }

    @Override
    public boolean isInMatrix(Entity entity) {
        return entity == get(entity.position());
    }

    @Override
    public Entity[][] getEntities() {
        return entities;
    }

    @Override
    public int getWidth() {

        return entities[0].length;
    }

    @Override
    public int getHeight() {

        return entities.length;
    }
}
