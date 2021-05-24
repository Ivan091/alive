package alive.organic.cell;

import alive.field.*;


public class NavigatorMatrix implements Navigator {

    private final Field field;

    private final DirectionInspector directionInspector;

    private Position position;

    private boolean isAlive;

    public NavigatorMatrix(Field field, DirectionInspector directionInspector, Position position) {
        isAlive = true;
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

    @Override
    public void die() {
        field.erase(position);
        isAlive = false;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
