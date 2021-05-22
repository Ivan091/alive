package alive.field;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class DirectionInspectorMatrix implements DirectionInspector {

    private static final List<Function<Position, Position>> modifiers = new ArrayList<>();

    static {
        modifiers.add(p -> new PositionMatrix(p.x() + 1, p.y()));
        modifiers.add(p -> new PositionMatrix(p.x() + 1, p.y() + 1));
        modifiers.add(p -> new PositionMatrix(p.x(), p.y() + 1));
        modifiers.add(p -> new PositionMatrix(p.x() - 1, p.y() + 1));
        modifiers.add(p -> new PositionMatrix(p.x() - 1, p.y()));
        modifiers.add(p -> new PositionMatrix(p.x() - 1, p.y() - 1));
        modifiers.add(p -> new PositionMatrix(p.x(), p.y() - 1));
        modifiers.add(p -> new PositionMatrix(p.x() + 1, p.y() - 1));
    }

    int currentDirectionIdx = 0;

    @Override
    public Position inspect(Position currentPosition) {
        return modifiers.get(currentDirectionIdx).apply(currentPosition);
    }

    @Override
    public void rotate(int steps) {
        currentDirectionIdx += steps;
        currentDirectionIdx %= 8;
        if (currentDirectionIdx < 0) {
            currentDirectionIdx += 8;
        }
    }
}
