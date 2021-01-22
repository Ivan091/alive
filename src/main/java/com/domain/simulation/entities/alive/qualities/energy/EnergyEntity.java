package com.domain.simulation.entities.alive.qualities.energy;

import java.util.function.Function;

public class EnergyEntity implements Energy {

    protected double energyValue;

    public EnergyEntity(double energyValue) {
        this.energyValue = energyValue;
    }

    @Override
    public final double value() {
        return energyValue;
    }

    @Override
    public void changeValue(Function<Double, Double> function) {
        energyValue = function.apply(energyValue);
    }
}
