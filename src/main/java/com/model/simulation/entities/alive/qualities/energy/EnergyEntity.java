package com.model.simulation.entities.alive.qualities.energy;

public class EnergyEntity implements Energy {

    protected int energyValue;

    public EnergyEntity(int energyValue) {
        this.energyValue = energyValue;
    }

    @Override
    public final int getEnergyValue() {
        return energyValue;
    }

    @Override
    public final void setEnergyValue(int newValue) {

        energyValue = newValue;
    }
}
