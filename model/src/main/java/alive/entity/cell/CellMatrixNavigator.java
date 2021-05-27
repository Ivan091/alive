package alive.entity.cell;

import alive.entity.Entity;
import alive.entity.Navigator;
import alive.simulation.*;
import java.util.List;
import java.util.function.Function;


public final class CellMatrixNavigator implements Navigator {

    private static final List<Function<Position, Position>> possibleDirs;

    static {
        possibleDirs = List.of(
                p -> new PositionMatrix(p.x() + 1, p.y()),
                p -> new PositionMatrix(p.x() + 1, p.y() + 1),
                p -> new PositionMatrix(p.x(), p.y() + 1),
                p -> new PositionMatrix(p.x() - 1, p.y() + 1),
                p -> new PositionMatrix(p.x() - 1, p.y()),
                p -> new PositionMatrix(p.x() - 1, p.y() - 1),
                p -> new PositionMatrix(p.x(), p.y() - 1),
                p -> new PositionMatrix(p.x() + 1, p.y() - 1)
        );
    }

    private final Field field;

    private Position currentPos;

    private int dirIdx;

    public CellMatrixNavigator(Field field, Position currentPos) {
        this.field = field;
        this.currentPos = currentPos;
    }

    @Override
    public void goAhead() {
        var newPos = possibleDirs.get(dirIdx).apply(currentPos);
        if (field.isEmpty(newPos)) {
            field.relocate(currentPos, newPos);
            currentPos = newPos;
        }
    }

    @Override
    public void rotate(int step) {
        dirIdx = Math.floorMod(dirIdx + step, dirIdx);
    }

    @Override
    public void erase() {
        field.empty(currentPos);
    }

    @Override
    public boolean isOnPosition(Entity entity) {
        return field.search(currentPos).equals(entity);
    }
}
