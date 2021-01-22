package com.domain.simulation.entities.alive.qualities.energy;

import java.util.function.Function;

public interface Energy {

    double value();

    /**
     * @param function function applied to current value.
     */
    void changeValue(Function<Double, Double> function);
}
