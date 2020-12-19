package alive.entities.qualities.position;

import java.util.Objects;

public class PositionEntity implements Position {

    private final int x;
    private final int y;

    public PositionEntity(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public PositionEntity(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    @Override
    public int getX() {

        return x;
    }

    @Override
    public int getY() {

        return y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositionEntity that = (PositionEntity) o;
        return x == that.x && y == that.y;
    }

    @Override
    public String toString() {

        return "BotPosition {" +
                " x = " + x +
                ", y = " + y +
                " }";
    }
}
