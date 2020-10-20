package alive.bot.model;

import alive.bot.direction.look.LookDirection;
import alive.bot.energy.Energy;
import alive.bot.genome.Genome;
import alive.bot.position.Position;
import alive.field.cell.content.CellContent;

public interface Bot extends CellContent, Alive {

    Position getPosition();

    Energy getEnergy();

    Genome getGenome();

    LookDirection getLookDirection();
}
