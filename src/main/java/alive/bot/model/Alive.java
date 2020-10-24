package alive.bot.model;

import alive.bot.condition.Condition;
import alive.bot.model.mortal.Mortal;
import alive.bot.position.Position;

public interface Alive extends Mortal, Movable {

    Condition getLiveCondition();

    Position getPosition();

    boolean isAlive();
}
