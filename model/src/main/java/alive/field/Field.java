package alive.field;

import alive.Entity;


public interface Field {

    Entity search(PositionCartesian position);

    void place(Entity entity, PositionCartesian position);

    void relocate(PositionCartesian oldPosition, PositionCartesian newPosition);

    boolean isInBounds(PositionCartesian position);
}
