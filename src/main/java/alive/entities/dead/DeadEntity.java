package alive.entities.dead;

import alive.entities.Entity;
import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.position.Position;

public abstract class DeadEntity implements Entity {

    private final Energy energy;

    private final Position position;

    public DeadEntity(Position position, Energy energy) {
        this.position = position;
        this.energy = energy;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Energy getEnergy() {
        return energy;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public abstract void finalizeBeforeErasingFromField();

    @Override
    public void makeAMove() {
        
    }
}
