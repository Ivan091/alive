package alive.simulation;

public final class PositionMatrix implements Position {

    private final int x;

    private final int y;

    public PositionMatrix(Position pos) {
        this(pos.x(), pos.y());
    }

    public PositionMatrix(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
