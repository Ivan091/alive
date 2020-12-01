package alive.bot.model;

import alive.bot.direction.look.LookDirection;
import alive.bot.energy.Energy;
import alive.bot.genome.Genome;
import alive.bot.position.Position;
import alive.field.Field;

public interface Bot extends Alive {

    Field getField();

    Energy getEnergy();

    Genome getGenome();

    LookDirection getLookDirection();

    Position getLookingPos();
}
