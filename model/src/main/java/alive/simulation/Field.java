package alive.simulation;

import alive.entity.Entity;


public interface Field {

    void place(Entity entity, Position pos);

    Entity search(Position pos);

    void empty(Position pos);

    void relocate(Position oldPos, Position newPos);

    boolean isInBounds(Position pos);

    boolean isEmpty(Position pos);

    Entity[][] state();
}
