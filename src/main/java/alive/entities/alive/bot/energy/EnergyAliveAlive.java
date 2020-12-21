package alive.entities.alive.bot.energy;

import alive.WorldConstants;
import alive.entities.alive.Mortal;
import alive.entities.qualities.energy.EnergyEntity;

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
