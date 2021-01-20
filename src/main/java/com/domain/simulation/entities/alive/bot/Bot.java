package com.domain.simulation.entities.alive.bot;

import com.domain.simulation.entities.alive.Alive;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.direction.LookDirection;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.field.Field;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

public interface Bot extends Alive {

    boolean isFriendly(Bot otherBot);

    @JsonBackReference
    Field getField();

    @JsonIgnore
    Genome getGenome();

    @JsonIgnore
    LookDirection getLookDirection();

    @JsonIgnore
    Optional<Position> getObservedPos();
}
