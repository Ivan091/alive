package alive.field.matrix;

import alive.entities.Entity;
import alive.entities.lifeless.Empty;
import alive.entities.lifeless.EmptyEntity;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;

import java.util.*;

public class MatrixLiveEntities implements MatrixEntities {

    private final Entity[][] entities;

    public MatrixLiveEntities(int height, int width) {

        entities = new Entity[width][height];
        for (var i = 0; i < width; ++i) {
            for (var j = 0; j < height; ++j) {
                var pos = createPositionInside(i, j);
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

        var y = pos.getY();
        if (y < 0 || y >= getHeight()) {
            return Optional.empty();
        }

        var x = pos.getX();
        if (x < 0 || x >= getWidth()) {
            x %= getWidth();
            x = x >= 0 ? x : x + getWidth();
        }
        pos.setX(x);

        return Optional.of(pos);
    }

    @Override
    public List<Position> findEmptyPositionsAround(Position pos) {
        var positionsAround = new ArrayList<Position>(8);

        var x = pos.getX();
        var y = pos.getY();

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
        return entities[pos.getX()][pos.getY()];
    }

    @Override
    public Entity put(Entity newEntity) {
        var pos = newEntity.getPosition();
        var previousEntity = get(pos);
        entities[pos.getX()][pos.getY()] = newEntity;
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
        return entity == get(entity.getPosition());
    }

    @Override
    public int getWidth() {

        return entities.length;
    }

    @Override
    public int getHeight() {

        return entities[0].length;
    }
}
