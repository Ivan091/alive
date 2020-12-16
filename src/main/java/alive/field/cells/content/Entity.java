package alive.field.cells.content;

import alive.bot.energy.Energy;
import alive.bot.position.Position;

public interface Entity {

    Position getPosition();

    Energy getEnergy();

    boolean isAlive();

    void finalizeBeforeErasingFromField();
}
