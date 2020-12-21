package alive.entities;

import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.position.Position;

public interface Entity {

    Position getPosition();
    
    void setPosition(Position newPos);

    Energy getEnergy();

    boolean isAlive();

    void finalizeBeforeErasingFromField();
}
