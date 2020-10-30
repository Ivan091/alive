package alive.bot.position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BotPosition implements Position {

    private int x;
    private int y;

    public BotPosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public List<Position> getPositionsAround() {

        var positionsAround = new ArrayList<Position>(8);

        for (var i = getX() - 1; i <= getX() + 1; ++i) {
            for (var j = getY() - 1; j <= getY() + 1; ++j) {
                if (i != getX() || j != getY()) {
                    var newPosition = new BotPosition(i, j);
                    positionsAround.add(newPosition);
                }
            }
        }

        return positionsAround;
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
    public void setX(int x) {

        this.x = x;
    }

    @Override
    public void setY(int y) {

        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BotPosition that = (BotPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {

        return "BotPosition {" +
                " x = " + x +
                ", y = " + y +
                " }";
    }
}
