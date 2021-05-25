package alive.field;

import alive.Entity;
import java.util.List;


public interface Field {

    Entity search(Position position);

    void place(Entity entity, Position position);

    void relocate(Position oldPosition, Position newPosition);

    void erase(Position position);

    boolean isInBounds(Position position);

    boolean isHollow(Position position);

    List<Position> searchHollowAround(Position position);
}
