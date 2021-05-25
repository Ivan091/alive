package alive.field.matrix;

import alive.field.*;


public class DirectionInspectorMatrix implements DirectionInspector {

    private final DirectionModifier directionModifier;

    private int directionIndex;

    public DirectionInspectorMatrix(int directionIndex, DirectionModifier directionModifier) {
        this.directionIndex = directionIndex;
        this.directionModifier = directionModifier;
    }

    @Override
    public Position inspect(Position currentPosition) {
        return directionModifier.modify(currentPosition, directionIndex);
    }

    @Override
    public void rotate(int steps) {
        directionIndex += steps;
        directionIndex %= 8;
        if (directionIndex < 0) {
            directionIndex += 8;
        }
    }

    @Override
    public DirectionInspector reproduce() {
        return new DirectionInspectorMatrix(directionIndex, directionModifier.reproduce());
    }
}
