package alive.bot.model;

import alive.bot.condition.Condition;
import alive.bot.model.mortal.Mortal;

public interface Alive extends Mortal, Movable {

    Condition getLiveCondition();

    boolean isAlive();
}
