package alive.bot.energy;

import alive.WorldConstants;
import alive.bot.model.mortal.Mortal;

public class BotEnergy implements Energy {

    private final Mortal bot;
    private int energyValue;

    public BotEnergy(Mortal bot, int energyValue) {

        this.bot = bot;
        this.energyValue = energyValue;
    }

    @Override
    public int getEnergyValue() {

        return energyValue;
    }

    @Override
    public void setEnergyValue(int newValue) {

        energyValue = newValue;
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
