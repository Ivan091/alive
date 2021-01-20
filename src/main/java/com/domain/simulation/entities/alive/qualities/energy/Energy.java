package com.domain.simulation.entities.alive.qualities.energy;

public interface Energy {

    int getEnergyValue();

    /**
     * Sets new energy value. <b>Doesn't notify alive</b>.
     *
     * @param newValue new energy value
     */
    void setEnergyValue(int newValue);
}
