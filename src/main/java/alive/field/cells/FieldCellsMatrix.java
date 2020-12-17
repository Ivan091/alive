package alive.field.cells;

import alive.entities.Entity;
import alive.entities.dead.Empty;
import alive.entities.dead.EmptyEntity;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;

import java.util.Optional;

public class FieldCellsMatrix implements CellsMatrix {

    private final Entity[][] cellsMatrix;

    public FieldCellsMatrix(int height, int width) {

        cellsMatrix = new Entity[width][height];
        for (var i = 0; i < width; ++i) {
            for (var j = 0; j < height; ++j) {
                var pos = createPositionOnField(i, j);
                if (pos.isPresent()) {
                    cellsMatrix[i][j] = new EmptyEntity(pos.get(), new EnergyEntity(0));
                }
            }
        }
    }

    public Optional<Position> createPositionOnField(int x, int y) {

        if (y < 0 || y >= getHeight()) {
            return Optional.empty();
        }

        if (x < 0 || x >= getWidth()) {
            x %= getWidth();
            x = x >= 0 ? x : x + getWidth();
        }

        return Optional.of(new PositionEntity(x, y));
    }

    @Override
    public Optional<Position> createPositionOnField(Position pos) {
        return createPositionOnField(pos.getX(), pos.getY());
    }

    @Override
    public Entity getEntity(Position pos) {
        return cellsMatrix[pos.getX()][pos.getY()];
    }

    @Override
    public void addEntity(Entity newEntity) {
        var pos = newEntity.getPosition();
        cellsMatrix[pos.getX()][pos.getY()] = newEntity;
    }

    @Override
    public void addEmpty(Position pos) {

        getEntity(pos).finalizeBeforeErasingFromField();
        addEntity(new EmptyEntity(new PositionEntity(pos), new EnergyEntity(0)));
    }

    @Override
    public void finalizeEntity(Position pos) {
        getEntity(pos).finalizeBeforeErasingFromField();
    }

    @Override
    public boolean isEmpty(Position pos) {

        return getEntity(pos) instanceof Empty;
    }

    @Override
    public int getWidth() {

        return cellsMatrix.length;
    }

    @Override
    public int getHeight() {

        return cellsMatrix[0].length;
    }
}
