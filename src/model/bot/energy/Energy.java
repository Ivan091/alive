package model.bot.energy;

import model.bot.IBotReplicateAndDie;

public class Energy implements IEnergy {

    private IBotReplicateAndDie bot;
    private int energyValue;

    public Energy(IBotReplicateAndDie bot, int energyValue) {
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

        if (energyValue <= 0)
            bot.Die();

        if (energyValue > 1000)
            bot.Replicate();
    }

    @Override
    public void changeEnergyValue(int changing) {
        setEnergyValue(energyValue + changing);
    }
}
