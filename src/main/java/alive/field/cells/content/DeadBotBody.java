package alive.field.cells.content;

import alive.bot.energy.Energy;
import alive.bot.position.Position;

public class DeadBotBody extends DeadEntity {

    public DeadBotBody(Position position, Energy energy) {
        super(position, energy);
    }

    @Override
    public void finalizeBeforeErasingFromField() {

    }
}
