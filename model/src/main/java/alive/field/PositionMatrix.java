package alive.field;

public class PositionMatrix implements Position {

    private final int x;

    private final int y;

    public PositionMatrix(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionMatrix(Position initPosition) {
        x = initPosition.x();
        y = initPosition.y();
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }
}
