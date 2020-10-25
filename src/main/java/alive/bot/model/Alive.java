package alive.bot.model;

import alive.bot.condition.Condition;
import alive.bot.model.mortal.Mortal;
import alive.bot.position.Position;
import alive.field.cell.content.CellContent;

public interface Alive extends Mortal, Movable, CellContent {

    Condition getLiveCondition();

    Position getPosition();

    boolean isAlive();
}
