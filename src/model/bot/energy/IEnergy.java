package model.bot.energy;

public interface IEnergy {

    int getEnergyValue();

    void setEnergyValue(int newEnergyValue);

    void changeEnergyValue(int changing);
}
