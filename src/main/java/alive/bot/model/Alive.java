package alive.bot.model;

import alive.bot.model.mortal.Mortal;
import alive.bot.position.Position;
import alive.field.cells.content.Content;

public interface Alive extends Mortal, Movable, Content {

    Position getPosition();

    void setPosition(Position newPos);

    boolean isAlive();
}
