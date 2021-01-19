package com.model.simulation.entities.alive.qualities.position;

public class PositionEntity implements Position {

    private int x;
    private int y;

    public PositionEntity(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public PositionEntity(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    @Override
    public void copyOf(Position other) {
        x = other.getX();
        y = other.getY();
    }

    @Override
    public final int getX() {

        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public final int getY() {

        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
