package alive.entities.alive.bot.energy;

import alive.entities.alive.Alive;
import alive.entities.alive.Mortal;
import alive.entities.qualities.energy.Energy;

public interface EnergyBot extends Energy {

    void subscribeMortal(Mortal mortal);

    /**
     * Increments current energy value. Notifies alive if it must be replicated or destroyed.
     *
     * @param increment the value of the energy increment.
     * @see #notifyMortal()
     */
    void incrementEnergyValue(int increment);

    /**
     * Notifies alive if it must be replicated or destroyed.
     *
     * @see Alive
     */
    void notifyMortal();
}
