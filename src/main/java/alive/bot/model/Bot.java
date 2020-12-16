package alive.bot.model;

import alive.bot.direction.look.LookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.genome.Genome;
import alive.bot.position.Position;
import alive.field.Field;

import java.util.Optional;

public interface Bot extends Alive {

    Field getField();

    BotEnergy getEnergy();

    Genome getGenome();

    LookDirection getLookDirection();

    Optional<Position> getLookingPos();
}
