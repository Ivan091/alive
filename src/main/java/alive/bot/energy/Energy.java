package alive.bot.energy;

public interface Energy {

    int getEnergyValue();

    void setEnergyValue(int newValue);

    /**
     * Increments current energy value.
     *
     * @param increment the value of the energy increment.
     */
    void incrementEnergyValue(int increment);
}
