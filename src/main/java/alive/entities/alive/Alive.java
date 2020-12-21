package alive.entities.alive;

import alive.entities.Entity;
import alive.entities.alive.bot.energy.EnergyAlive;

public interface Alive extends Mortal, Entity {

    EnergyAlive getEnergy();
}
