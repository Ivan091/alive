package com.domain.simulation.entities.alive.qualities.position;

public interface Position {

    void copyOf(Position other);

    int x();

    int y();
}
