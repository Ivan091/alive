package alive.field.matrix;

import alive.field.*;


public class DirectionInspectorMatrix implements DirectionInspector {

    private final DirectionModifier directionModifier;

    private int directionIdx;

    public DirectionInspectorMatrix(int directionIdx, DirectionModifier directionModifier) {
        this.directionIdx = directionIdx;
        this.directionModifier = directionModifier;
    }

    @Override
    public Position inspect(Position currentPosition) {
        return directionModifier.modify(currentPosition, directionIdx);
    }

    @Override
    public void rotate(int steps) {
        directionIdx += steps;
        directionIdx %= 8;
        if (directionIdx < 0) {
            directionIdx += 8;
        }
    }
}
