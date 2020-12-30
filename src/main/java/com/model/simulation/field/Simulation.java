package com.model.simulation.field;

public interface Simulation {
    void start();

    void nextMove();

    String currentCondition();
}
