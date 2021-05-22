package alive.field;

import alive.Entity;


public interface Field {

    Entity get(PositionCartesian position);

    boolean place(Entity entity, PositionCartesian position);

    boolean relocate(PositionCartesian oldPosition, PositionCartesian newPosition);

    boolean isInBounds(PositionCartesian position);
}
