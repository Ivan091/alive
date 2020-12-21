package alive.entities.alive;

import alive.entities.EntityAbstract;
import alive.entities.alive.bot.energy.EnergyAlive;
import alive.entities.qualities.position.Position;

public abstract class AliveEntity extends EntityAbstract implements Alive {

    protected final EnergyAlive energy;

    public AliveEntity(Position position, EnergyAlive energy) {
        super(position);
        this.energy = energy;
    }

    @Override
    public final EnergyAlive getEnergy() {
        return energy;
    }
}
