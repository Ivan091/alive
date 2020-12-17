package alive.entities.dead;

import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.position.Position;

public class EmptyEntity extends DeadEntity implements Empty {

    public EmptyEntity(Position position, Energy energy) {
        super(position, energy);
    }

    @Override
    public void finalizeBeforeErasingFromField() {

    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }
}
