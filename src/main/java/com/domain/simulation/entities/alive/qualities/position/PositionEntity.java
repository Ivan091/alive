package com.domain.simulation.entities.alive.qualities.position;

public class PositionEntity implements Position {

    private int x;
    private int y;

    public PositionEntity(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public PositionEntity(Position pos) {
        this.x = pos.x();
        this.y = pos.y();
    }

    @Override
    public void copyOf(Position other) {
        x = other.x();
        y = other.y();
    }

    @Override
    public final int x() {

        return x;
    }

    @Override
    public final int y() {

        return y;
    }

    @Override
    public int hashCode() {

        return x ^ y;
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

        return "PositionEntity {" +
                " x = " + x +
                ", y = " + y +
                " }";
    }
}
