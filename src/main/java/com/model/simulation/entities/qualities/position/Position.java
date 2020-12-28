package com.model.simulation.entities.qualities.position;

public interface Position {

    void copyOf(Position other);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);
}
