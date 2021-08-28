package alive.entity;

import alive.common.ArrayUtils;
import alive.simulation.*;
import java.util.*;
import java.util.function.Function;


public final class MatrixNavigator implements Navigator {

    private static final List<Function<Position, Position>> possibleDirs = List.of(
            p -> new PositionMatrix(p.x() + 1, p.y()),
            p -> new PositionMatrix(p.x() + 1, p.y() + 1),
            p -> new PositionMatrix(p.x(), p.y() + 1),
            p -> new PositionMatrix(p.x() - 1, p.y() + 1),
            p -> new PositionMatrix(p.x() - 1, p.y()),
            p -> new PositionMatrix(p.x() - 1, p.y() - 1),
            p -> new PositionMatrix(p.x(), p.y() - 1),
            p -> new PositionMatrix(p.x() + 1, p.y() - 1)
    );

    private final Field field;

    private Position pos;

    private int dirIdx;

    public MatrixNavigator(Field field, Position pos) {
        this(field, pos, 2);
    }

    public MatrixNavigator(Field field, Position pos, int dirIdx) {
        this.field = field;
        this.pos = pos;
        this.dirIdx = ArrayUtils.makeLoopedInside(dirIdx, possibleDirs.size());
    }

    @Override
    public void goAhead(Entity entity) {
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
    public void register(Entity entity) {
        field.place(entity, pos);
    }

    @Override
    public void unregister() {
        field.empty(pos);
    }

    @Override
    public boolean isRegistered(Entity entity) {
        return field.search(pos).equals(entity);
    }

    @Override
    public Optional<Entity> look() {
        var lookedPos = possibleDirs.get(dirIdx).apply(pos);
        if (field.isInBounds(lookedPos)) {
            return Optional.of(field.search(lookedPos));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Navigator> replicate() {
        var oldDirIdx = dirIdx;
        var possAround = new ArrayList<Position>(8);
        do {
            var possiblePos = possibleDirs.get(dirIdx).apply(pos);
            if (field.isEmpty(possiblePos)) {
                possAround.add(possiblePos);
            }
            rotate(1);
        } while (oldDirIdx != dirIdx);
        if (possAround.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(new MatrixNavigator(field, possAround.get(new Random().nextInt(possAround.size())), dirIdx + 4));
        }
    }
}
