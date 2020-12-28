package com.model.simulation.entities.qualities.energy;

public class EnergyEntity implements Energy {

    protected int energyValue;

    public EnergyEntity(int energyValue) {
        this.energyValue = energyValue;
    }

    public EnergyEntity(Energy energy) {
        energyValue = energy.getEnergyValue();
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
