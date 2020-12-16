package alive.bot.position;

import alive.field.cells.CellsMatrix;

import java.util.*;

public class EntityPosition implements Position {

    private final int x;
    private final int y;

    public EntityPosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public EntityPosition(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    @Override
    public List<Position> getPositionsAround(CellsMatrix cellsMatrix) {

        var positionsAround = new ArrayList<Position>(8);

        for (var i = getX() - 1; i <= getX() + 1; ++i) {
            for (var j = getY() - 1; j <= getY() + 1; ++j) {
                if (i != getX() || j != getY()) {
                    cellsMatrix.createPositionOnField(i, j).ifPresent(positionsAround::add);
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
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntityPosition that = (EntityPosition) o;
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
