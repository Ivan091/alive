package com.domain.simulation.entities.alive;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;

public interface Alive extends Mortal, Entity {

    EnergyMortal getEnergy();
}
