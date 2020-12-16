package alive.bot.model;

import alive.bot.model.mortal.Mortal;
import alive.bot.position.Position;
import alive.field.cells.content.Entity;

public interface Alive extends Mortal, Movable, Entity {

    Position getPosition();

    void setPosition(Position newPos);

    boolean isAlive();
}
