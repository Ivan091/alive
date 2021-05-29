package alive.entity.cell;

import alive.entity.Entity;
import alive.entity.Navigator;
import alive.simulation.*;
import java.util.*;
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

    private Field field;

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
    public void goAhead(Entity entity) {
        var newPos = possibleDirs.get(dirIdx).apply(pos);
        if (field.isEmpty(newPos)) {
            unregister();
            pos = newPos;
            register(entity);
        }
    }

    @Override
    public void unregister() {
        field.empty(pos);
    }

    @Override
    public void register(Entity entity) {
        field.place(entity, pos);
    }

    @Override
    public boolean isRegistered(Entity entity) {
        return field.search(pos).equals(entity);
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
        if (possAround.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.of(new CellNavigator(field, possAround.get(new Random().nextInt(possAround.size()))));
        }
    }

    @Override
    public void rotate(int step) {
        dirIdx = Math.floorMod(dirIdx + step, possibleDirs.size());
    }
}
