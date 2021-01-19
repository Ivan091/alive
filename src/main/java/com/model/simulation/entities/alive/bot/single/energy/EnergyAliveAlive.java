package com.model.simulation.entities.alive.bot.single.energy;

import com.model.simulation.WorldConstants;
import com.model.simulation.entities.alive.Mortal;
import com.model.simulation.entities.qualities.energy.EnergyEntity;

public class EnergyAliveAlive extends EnergyEntity implements EnergyAlive {

    private Mortal mortal;

    public EnergyAliveAlive(int energyValue) {
        super(energyValue);
    }

    @Override
    public void subscribeMortal(Mortal mortal) {
        this.mortal = mortal;
    }

    @Override
    public void incrementEnergyValue(int increment) {

        energyValue += increment;
        notifyMortal();
    }

    @Override
    public void notifyMortal() {
        if (energyValue < WorldConstants.MIN_ENERGY_VALUE) {
            mortal.destroy();
        }

        if (energyValue > WorldConstants.MAX_ENERGY_VALUE) {
            mortal.replicate();
        }
    }
}
