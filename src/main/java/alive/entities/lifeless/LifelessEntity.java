package alive.entities.lifeless;

import alive.entities.PureEntity;
import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.position.Position;

public abstract class LifelessEntity extends PureEntity {

    private final Energy energy;

    public LifelessEntity(Position position, Energy energy) {
        super(position);
        this.energy = energy;
    }

    @Override
    public final boolean isAlive() {
        return false;
    }

    @Override
    public final Energy getEnergy() {
        return energy;
    }

    @Override
    public final void finalizeBeforeErasingFromField() {
    }
}
