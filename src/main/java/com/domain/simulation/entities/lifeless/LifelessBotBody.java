package com.domain.simulation.entities.lifeless;

import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.position.Position;

public class LifelessBotBody extends LifelessEntity {

    public LifelessBotBody(Position position, Energy energy) {
        super(position, new ColorEntity(130, 130, 130), energy);
    }
}
