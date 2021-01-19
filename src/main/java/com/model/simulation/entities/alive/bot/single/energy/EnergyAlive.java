package com.model.simulation.entities.alive.bot.single.energy;

import com.model.simulation.entities.alive.Alive;
import com.model.simulation.entities.alive.Mortal;
import com.model.simulation.entities.qualities.energy.Energy;

public interface EnergyAlive extends Energy {

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
