package com.model.simulation.entities.alive.bot;

import com.model.simulation.entities.alive.Alive;
import com.model.simulation.entities.alive.bot.genome.Genome;
import com.model.simulation.entities.qualities.direction.LookDirection;
import com.model.simulation.entities.qualities.position.Position;
import com.model.simulation.field.Field;

import java.util.Optional;

public interface Bot extends Alive {

    Field getField();

    Genome getGenome();

    LookDirection getLookDirection();

    Optional<Position> getLookingPos();
}
