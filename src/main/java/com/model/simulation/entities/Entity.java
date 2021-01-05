package com.model.simulation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.model.simulation.entities.qualities.color.Color;
import com.model.simulation.entities.qualities.energy.Energy;
import com.model.simulation.entities.qualities.position.Position;

public interface Entity {

    /**
     * Calls when entity makes a move.
     */
    void makeAMove();

    @JsonIgnore
    boolean isAlive();

    Position getPosition();

    @JsonUnwrapped
    Energy getEnergy();

    Color getColor();
}
