package com.model.simulation;

import com.model.simulation.field.Field;

public interface Simulation {

    void start();

    /**
     * Calls
     */
    void nextMove();

    Field getField();
}
