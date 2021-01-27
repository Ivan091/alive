package com.domain.simulation.entities.alive.bot;

import com.domain.simulation.entities.alive.Alive;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.direction.LookDirection;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.field.matrix.MatrixEntities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

public interface Bot extends Alive {

    boolean isFriendly(Bot bot);

    @JsonBackReference
    MatrixEntities matrixEntities();

    @JsonIgnore
    Genome genome();

    @JsonIgnore
    LookDirection lookDirection();

    @JsonIgnore
    Optional<Position> observedPos();
}
