package com.model.simulation.entities.lifeless;

import com.model.simulation.entities.qualities.color.ColorEntity;
import com.model.simulation.entities.qualities.energy.Energy;
import com.model.simulation.entities.qualities.position.Position;

public class LifelessBotBody extends LifelessEntity {

    public LifelessBotBody(Position position, Energy energy) {
        super(position, new ColorEntity(130, 130, 130), energy);
    }
}
