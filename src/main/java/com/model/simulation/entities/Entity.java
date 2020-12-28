package com.model.simulation.entities;

import com.model.simulation.entities.qualities.energy.Energy;
import com.model.simulation.entities.qualities.position.Position;

public interface Entity {

    Position getPosition();

    Energy getEnergy();

    boolean isAlive();

    /**
     * Calls when entity makes a move.
     */
    void makeAMove();
}
