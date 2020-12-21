package alive.entities.alive;

import alive.entities.Entity;
import alive.entities.Movable;
import alive.entities.alive.bot.energy.EnergyAlive;
import alive.entities.qualities.position.Position;

public interface Alive extends Mortal, Movable, Entity, Replicable {

    Position getPosition();

    void setPosition(Position newPos);

    EnergyAlive getEnergy();

    boolean isAlive();
}
