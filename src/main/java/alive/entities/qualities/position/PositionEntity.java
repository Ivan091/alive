package alive.entities.qualities.position;

import alive.field.cells.CellsMatrix;

import java.util.*;

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
        PositionEntity that = (PositionEntity) o;
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
