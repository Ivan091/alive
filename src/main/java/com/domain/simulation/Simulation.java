package com.domain.simulation;

import com.domain.simulation.field.Field;

public interface Simulation {

    void start();

    /**
     * Calls
     */
    void nextMove();

    Field getField();
}
