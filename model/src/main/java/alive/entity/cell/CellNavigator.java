package alive.entity.cell;

import alive.entity.Entity;
import alive.entity.Navigator;
import alive.simulation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public final class CellNavigator implements Navigator {

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

    private Position pos;

    private int dirIdx;

    public CellNavigator(Field field, Position pos) {
        this(field, pos, 0);
    }

    public CellNavigator(Field field, Position pos, int dirIdx) {
        this.field = field;
        this.pos = pos;
        this.dirIdx = dirIdx;
    }

    @Override
    public void goAhead() {
        var newPos = possibleDirs.get(dirIdx).apply(pos);
        if (field.isEmpty(newPos)) {
            field.relocate(pos, newPos);
            pos = newPos;
        }
    }

    @Override
    public void rotate(int step) {
        dirIdx = Math.floorMod(dirIdx + step, possibleDirs.size());
    }

    @Override
    public void erase() {
        field.empty(pos);
    }

    @Override
    public List<Position> findEmptyAround() {
        var oldDirIdx = dirIdx;
        var possAround = new ArrayList<Position>(8);
        do {
            var possiblePos = possibleDirs.get(dirIdx).apply(pos);
            if (field.isEmpty(possiblePos)) {
                possAround.add(possiblePos);
            }
            rotate(1);
        } while (oldDirIdx != dirIdx);
        return possAround;
    }

    @Override
    public void register(Entity entity) {
        field.place(entity, pos);
    }

    @Override
    public boolean isOnPosition(Entity entity) {
        return field.search(pos).equals(entity);
    }

    @Override
    public Navigator replicate(Position position) {
        return new CellNavigator(field, position);
    }
}
