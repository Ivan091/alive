package alive.bot.direction;

public interface Direction {

    double getX();

    double getY();

    /**
     *
     * @param angle angle in degrees. If positive - rotates counterclockwise,
     *              if negative - clockwise.
     */
}
