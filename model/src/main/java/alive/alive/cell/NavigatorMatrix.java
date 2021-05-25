package alive.alive.cell;

import alive.Entity;
import alive.alive.Navigator;
import alive.field.*;
import java.util.Optional;
import java.util.Random;


public class NavigatorMatrix implements Navigator {

    private final Field field;

    private final DirectionInspector directionInspector;

    private Position position;

    private Entity alive;

    public NavigatorMatrix(Field field, DirectionInspector directionInspector, Position position) {
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
    public Optional<Navigator> reproduce() {
        var rnd = new Random();
        var possiblePositions = field.searchHollowAround(position);
        if (possiblePositions.isEmpty()) {
            erase();
            alive.die();
            return Optional.empty();
        } else {
            var newPosition = possiblePositions.get(rnd.nextInt(possiblePositions.size()));
            return Optional.of(new NavigatorMatrix(field, directionInspector.reproduce(), newPosition));
        }
    }

    @Override
    public void subscribe(Entity observed) {
        alive = observed;
    }
}
