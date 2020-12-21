package alive.entities.lifeless;

import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.position.Position;

public class EmptyEntity extends LifelessEntity implements Empty {

    public EmptyEntity(Position position, Energy energy) {
        super(position, energy);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }
}