package alive.field;

public class PositionMatrix implements PositionCartesian {

    private int x;

    private int y;

    public PositionMatrix(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionMatrix(PositionCartesian initPosition) {
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

    @Override
    public void copyState(PositionCartesian copiedObject) {
        x = copiedObject.x();
        y = copiedObject.y();
    }
}
