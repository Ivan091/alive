package alive.field.matrix;

import alive.field.DirectionModifier;
import alive.field.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class DirectionMatrixModifier implements DirectionModifier {

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

    @Override
    public Position modify(Position position, int index) {
        return modifiers.get(index).apply(position);
    }

    @Override
    public DirectionModifier reproduce() {
        return this;
    }
}
