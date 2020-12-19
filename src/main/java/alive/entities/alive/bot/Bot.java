package alive.entities.alive.bot;

import alive.entities.alive.Alive;
import alive.entities.alive.bot.energy.EnergyBot;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.qualities.direction.LookDirection;
import alive.entities.qualities.position.Position;
import alive.field.Field;

import java.util.Optional;

public interface Bot extends Alive {

    Field getField();

    EnergyBot getEnergy();

    Genome getGenome();

    LookDirection getLookDirection();

    Optional<Position> getLookingPos();
}
