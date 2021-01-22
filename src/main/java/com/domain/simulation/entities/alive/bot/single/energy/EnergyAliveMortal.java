package com.domain.simulation.entities.alive.bot.single.energy;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.Mortal;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;

public class EnergyAliveMortal extends EnergyEntity implements EnergyMortal {

    private Mortal mortal;

    public EnergyAliveMortal(int energyValue) {
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
