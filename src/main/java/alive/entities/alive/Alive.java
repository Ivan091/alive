package alive.entities.alive;

import alive.entities.Entity;
import alive.entities.Movable;
import alive.entities.qualities.position.Position;

public interface Alive extends Mortal, Movable, Entity {

    Position getPosition();

    void setPosition(Position newPos);

    boolean isAlive();
}
