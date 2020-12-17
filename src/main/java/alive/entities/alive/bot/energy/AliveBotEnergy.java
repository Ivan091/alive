package alive.entities.alive.bot.energy;

import alive.WorldConstants;
import alive.entities.alive.Mortal;
import alive.entities.qualities.energy.EnergyEntity;

public class AliveBotEnergy extends EnergyEntity implements BotEnergy {

    private final Mortal bot;

    public AliveBotEnergy(Mortal bot, int energyValue) {
        super(energyValue);
        this.bot = bot;
    }

    @Override
    public void incrementEnergyValue(int increment) {

        energyValue += increment;
        notifyBot();
    }

    @Override
    public void notifyAlive() {
        notifyBot();
    }

    private void notifyBot() {
        if (energyValue < WorldConstants.MIN_ENERGY_VALUE) {
            bot.destroy();
        }

        if (energyValue > WorldConstants.MAX_ENERGY_VALUE) {
            bot.replicate();
        }
    }

}
