package com.domain.simulation.entities.alive.bot;

import com.domain.simulation.entities.alive.EntityAlive;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.domain.simulation.entities.alive.qualities.direction.LookDirection;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.visitor.Visitor;
import com.domain.simulation.field.FieldMatrix;
import com.domain.simulation.field.matrix.MatrixEntities;

import java.util.Optional;

public abstract class BotAbstract extends EntityAlive implements Bot {

    protected final FieldMatrix field;

    protected final LookDirection lookDirection;

    protected final Genome genome;

    protected boolean isAlive = true;

    public BotAbstract(FieldMatrix field, Position position, EnergyMortal energy, LookDirection lookDirection, Genome genome) {
        super(position, energy, new ColorEntity(0, 0, 0));

        this.field = field;
        energy.subscribeMortal(this);

        this.genome = genome;
        this.lookDirection = lookDirection;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAlive() {

        return isAlive;
    }

    @Override
    public MatrixEntities matrixEntities() {
        return field.cellsMatrix();
    }

    @Override
    public Genome genome() {

        return genome;
    }

    @Override
    public LookDirection lookDirection() {

        return lookDirection;
    }

    @Override
    public Optional<Position> observedPos() {
        return field.cellsMatrix().makePositionToBeInside(lookDirection.getLookingPos(position));
    }
}
