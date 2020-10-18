package alive.bot.direction.look;

public class BotLookDirection implements LookDirection {

    private double x;
    private double y;

    public BotLookDirection(double x, double y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {

        return x;
    }

    @Override
    public double getY() {

        return y;
    }

    @Override
    public void rotate(int rotationSteps) {

        double angle = (rotationSteps * 45) * Math.PI / 180;

        var tx = x * Math.cos(angle) + y * Math.sin(angle);
        var ty = x * Math.sin(-angle) + y * Math.cos(angle);

        x = tx;
        y = ty;
    }
}


















