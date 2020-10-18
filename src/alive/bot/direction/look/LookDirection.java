package alive.bot.direction.look;

import alive.bot.direction.Direction;

public interface LookDirection extends Direction {

    /**
     * @param rotationSteps 1 step is 45 degrees because bot can have 8 different directions only.
     *                      If positive - rotates counterclockwise,
     *                      if negative - rotates clockwise.
     */
    void rotate(int rotationSteps);
}
