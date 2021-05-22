package alive.field;

import alive.Entity;


public interface Field {

    Entity search(Position position);

    void place(Entity entity, Position position);

    void relocate(Position oldPosition, Position newPosition);

    boolean isInBounds(Position position);

    boolean isHollow(Position position);
}
