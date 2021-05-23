package alive.field.matrix;

import alive.field.*;


public class Navigator implements alive.organic.Navigator {

    private final Field field;

    private final DirectionInspector directionInspector;

    private Position position;

    public Navigator(Field field, DirectionInspector directionInspector, Position position) {
        this.field = field;
        this.directionInspector = directionInspector;
        this.position = position;
    }

    @Override
    public void goAhead() {
        var positionAhead = directionInspector.inspect(position);
        if (field.isHollow(positionAhead)) {
            field.relocate(position, positionAhead);
            position = positionAhead;
        }
    }

    @Override
    public void rotate(int steps) {
        directionInspector.rotate(steps);
    }
}
