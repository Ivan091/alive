package alive.bot.energy;

public interface BotEnergy extends Energy {

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

}
