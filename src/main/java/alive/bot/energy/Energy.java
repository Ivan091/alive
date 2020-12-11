package alive.bot.energy;

public interface Energy {

    /**
     * Increments current energy value. Notifies alive if it must be replicated or destroyed.
     *
     * @param increment the value of the energy increment.
     * @see #notifyAlive()
     */
    void incrementEnergyValue(int increment);

    /**
     * Notifies alive if it must be replicated or destroyed.
     *
     * @see alive.bot.model.Alive
     */
    void notifyAlive();

    int getEnergyValue();

    /**
     * Sets new energy value. <b>Doesn't notify alive</b>.
     *
     * @param newValue new energy value
     */
    void setEnergyValue(int newValue);
}
