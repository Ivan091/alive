package com.model.simulation.entities.alive.bot;

import com.model.simulation.WorldConstants;
import com.model.simulation.entities.alive.AliveEntity;
import com.model.simulation.entities.alive.bot.energy.EnergyAlive;
import com.model.simulation.entities.alive.bot.energy.EnergyAliveAlive;
import com.model.simulation.entities.alive.bot.genome.Genome;
import com.model.simulation.entities.lifeless.LifelessBotBody;
import com.model.simulation.entities.qualities.color.ColorEntity;
import com.model.simulation.entities.qualities.direction.LookDirection;
import com.model.simulation.entities.qualities.energy.EnergyEntity;
import com.model.simulation.entities.qualities.position.Position;
import com.model.simulation.entities.qualities.position.PositionEntity;
import com.model.simulation.field.Field;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class BotAlive extends AliveEntity implements Bot {

    private final Field field;

    private final LookDirection lookDirection;

    private final Genome genome;

    private boolean isAlive = true;

    public BotAlive(Field field, Position position, EnergyAlive energy, LookDirection lookDirection, Genome genome) {
        super(position, energy, new ColorEntity(255, 0, 0));

        this.field = field;
        energy.subscribeMortal(this);

        this.genome = genome;
        this.lookDirection = lookDirection;
    }

    @Override
    public void replicate() {

        if (!isAlive) {
            return;
        }

        Position newBotPos;

        var positionBehindOfBot = field.getCellsMatrix().makePositionToBeInside(lookDirection.opposite().getLookingPos(position));

        if (positionBehindOfBot.isPresent() && field.getCellsMatrix().isEmpty(positionBehindOfBot.get())) {
            newBotPos = positionBehindOfBot.get();
        } else {
            var possiblePositions = field.getCellsMatrix().findEmptyPositionsAround(position);
            if (possiblePositions.isEmpty()) {
                destroy();
                return;
            } else {
                newBotPos = possiblePositions.get(ThreadLocalRandom.current().nextInt(possiblePositions.size()));
            }
        }
        energy.setEnergyValue(energy.getEnergyValue() - genome.length() * WorldConstants.GENE_REPLICATION_COST);
        var newBotEnergyValue = energy.getEnergyValue() >> 1;
        var newBotEnergy = new EnergyAliveAlive(newBotEnergyValue);
        energy.setEnergyValue(newBotEnergyValue);

        var newBot = new BotAlive(field, newBotPos, newBotEnergy,
                lookDirection.opposite(), genome.replicate());

        field.putEntity(newBot);
    }

    @Override
    public void destroy() {

        isAlive = false;
        var deadBody = new LifelessBotBody(new PositionEntity(position), new EnergyEntity(energy));
        field.getCellsMatrix().put(deadBody);
    }

    @Override
    public void makeAMove() {

        var isMoving = isAlive;
        for (int i = 0; isMoving && i < WorldConstants.BOT_MAX_GENES_PER_MOVE; ++i) {

            isMoving = isAlive && genome.runCurrentGene(this);

            energy.incrementEnergyValue(WorldConstants.BOT_RUN_GENE_ENERGY_INCREMENT);
        }
    }

    @Override
    public boolean isAlive() {

        return isAlive;
    }

    @Override
    public Field getField() {

        return field;
    }

    @Override
    public Genome getGenome() {

        return genome;
    }

    @Override
    public LookDirection getLookDirection() {

        return lookDirection;
    }

    @Override
    public Optional<Position> getLookingPos() {
        return field.getCellsMatrix().makePositionToBeInside(lookDirection.getLookingPos(position));
    }
}
