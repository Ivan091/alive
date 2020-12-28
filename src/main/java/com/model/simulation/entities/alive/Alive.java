package com.model.simulation.entities.alive;

import com.model.simulation.entities.Entity;
import com.model.simulation.entities.alive.bot.energy.EnergyAlive;

public interface Alive extends Mortal, Entity {

    EnergyAlive getEnergy();
}
