package alive.entities.alive;

import alive.entities.PureEntity;
import alive.entities.alive.bot.energy.EnergyAlive;
import alive.entities.qualities.position.Position;

public abstract class AliveEntity extends PureEntity implements Alive {

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
