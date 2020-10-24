package alive.bot.direction.look;

import alive.Cloneable;
import alive.bot.position.Position;

public interface LookDirection extends Cloneable<LookDirection> {

    /**
     * @param rotationSteps 1 step is 45 degrees because bot can have 8 different directions only.
     *                      If positive - rotates counterclockwise,
     *                      if negative - rotates clockwise.
     */
    void rotate(int rotationSteps);

    /**
     *
     * @param currentPosition current bot position.
     * @return the position bot is supposed to look at. The position can be out of bounds.
     */
    Position getLookingPos(Position currentPosition);

    LookDirection getOpposite();
}
