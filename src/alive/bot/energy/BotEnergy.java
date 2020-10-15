package alive.bot.energy;


import alive.bot.model.Bot;

public class BotEnergy implements Energy {

    private final Bot bot;
    private int energyValue;

    public BotEnergy(Bot bot, int energyValue) {

        this.energyValue = energyValue;
        this.bot = bot;
    }

    @Override
    public int getEnergyValue() {

        return energyValue;
    }

    @Override
    public void setEnergyValue(int newEnergyValue) {

        energyValue = newEnergyValue;

        if (energyValue <= 0) {
            bot.Destroy();
        }

        if (energyValue > 1000) {
            bot.Replicate();
        }
    }

    @Override
    public void changeEnergyValue(int changing) {

        setEnergyValue(energyValue + changing);
    }
}
