package com.domain.simulation.entities;

import com.domain.simulation.entities.alive.qualities.color.Color;
import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public interface Entity {

    void makeAMove();

    @JsonIgnore
    boolean isAlive();

    @JsonIgnore
    Position getPosition();

    @JsonUnwrapped
    Energy getEnergy();

    @JsonUnwrapped
    Color getColor();
}
