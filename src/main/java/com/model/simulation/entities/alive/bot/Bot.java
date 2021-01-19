package com.model.simulation.entities.alive.bot;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.simulation.entities.alive.Alive;
import com.model.simulation.entities.alive.bot.single.genome.Genome;
import com.model.simulation.entities.qualities.direction.LookDirection;
import com.model.simulation.entities.qualities.position.Position;
import com.model.simulation.field.Field;

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
