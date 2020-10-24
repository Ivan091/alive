package alive.bot.energy;

public interface Energy {
    
    int getEnergyValue();

    void setEnergyValue(int newValue);

    void changeEnergyValue(int changing);
}
