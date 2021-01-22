package com.domain.simulation.entities.alive.bot.single.energy;

import com.domain.simulation.entities.alive.Alive;
import com.domain.simulation.entities.alive.Mortal;
import com.domain.simulation.entities.alive.qualities.energy.Energy;

public interface EnergyMortal extends Energy {

    void subscribeMortal(Mortal mortal);

    /**
     * Increments current energy value. Notifies alive if it must be replicated or destroyed.
     *
     * @param increment the value of the energy increment.
     * @see #notifyMortal()
     */
    void incrementValue(int increment);

    /**
     * Notifies alive if it must be replicated or destroyed.
     *
     * @see Alive
     */
    void notifyMortal();
}
