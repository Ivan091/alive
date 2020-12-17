package alive.entities.alive.bot.energy;

import alive.entities.alive.Alive;
import alive.entities.qualities.energy.Energy;

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
     * @see Alive
     */
    void notifyAlive();

}
