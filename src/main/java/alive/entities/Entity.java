package alive.entities;

import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.position.Position;

public interface Entity extends Movable {

    Position getPosition();

    Energy getEnergy();

    boolean isAlive();

    void finalizeBeforeErasingFromField();
}
