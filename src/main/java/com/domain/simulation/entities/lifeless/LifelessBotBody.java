package com.domain.simulation.entities.lifeless;

import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.visitor.Visitor;

public class LifelessBotBody extends LifelessEntity implements LifelessBody {

    public LifelessBotBody(Position position, Energy energy) {
        super(position, new ColorEntity(130, 130, 130), energy);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
