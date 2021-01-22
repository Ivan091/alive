package com.domain.simulation.entities;

import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.visitor.Visitor;
import com.fasterxml.jackson.annotation.*;

public interface Entity {

    void makeAMove();

    void accept(Visitor visitor);

    @JsonUnwrapped
    Energy energy();

    void repaint(ColorEntity newColor);

    @JsonIgnore
    Position position();

    void relocate(Position newPos);

    @JsonProperty
    ColorEntity color();

    @JsonIgnore
    boolean isAlive();
}
