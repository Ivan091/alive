package com.model.simulation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.model.simulation.entities.alive.qualities.color.Color;
import com.model.simulation.entities.alive.qualities.energy.Energy;
import com.model.simulation.entities.alive.qualities.position.Position;

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
