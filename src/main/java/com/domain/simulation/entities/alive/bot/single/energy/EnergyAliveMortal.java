package com.domain.simulation.entities.alive.bot.single.energy;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.Mortal;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;

import java.util.function.Function;

public class EnergyAliveMortal extends EnergyEntity implements EnergyMortal {

    private Mortal mortal;

    public EnergyAliveMortal(double initValue, Mortal mortal) {
        super(initValue);
        this.mortal = mortal;
    }

    public EnergyAliveMortal(double initValue) {
        super(initValue);
    }

    @Override
    public void subscribeMortal(Mortal mortal) {
        this.mortal = mortal;
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

    @Override
    public void changeValue(Function<Double, Double> function) {
        super.changeValue(function);
        notifyMortal();
    }
}
