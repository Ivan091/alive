package com.domain.simulation.entities.alive.bot.single;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.BotAbstract;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyAliveMortal;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.direction.LookDirection;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.entities.lifeless.LifelessBotBody;
import com.domain.simulation.field.FieldMatrix;

import java.util.concurrent.ThreadLocalRandom;

public class BotSingle extends BotAbstract {

    public BotSingle(FieldMatrix field, Position position, EnergyMortal energy, LookDirection lookDirection, Genome genome) {
        super(field, position, energy, lookDirection, genome);
    }

    @Override
    public void replicate() {

        if (!isAlive) {
            return;
        }

        Position newBotPos;

        var positionBehindOfBot = field.cellsMatrix().makePositionToBeInside(lookDirection.opposite().getLookingPos(position));

        if (positionBehindOfBot.isPresent() && field.cellsMatrix().isEmpty(positionBehindOfBot.get())) {
            newBotPos = positionBehindOfBot.get();
        } else {
            var possiblePositions = field.cellsMatrix().findEmptyPositionsAround(position);
            if (possiblePositions.isEmpty()) {
                destroy();
                return;
            } else {
                newBotPos = possiblePositions.get(ThreadLocalRandom.current().nextInt(possiblePositions.size()));
            }
        }
        energy.changeValue(v -> v - genome.length() * WorldConstants.GENE_REPLICATION_COST);
        var newBotEnergyValue = energy.value() * 0.5;
        var newBotEnergy = new EnergyAliveMortal(newBotEnergyValue);
        energy.changeValue(v -> newBotEnergyValue);

        var newBot = new BotSingle(field, newBotPos, newBotEnergy,
                lookDirection.opposite(), genome.replicate());
        field.putEntity(newBot);
    }

    @Override
    public void destroy() {

        isAlive = false;
        var deadBody = new LifelessBotBody(new PositionEntity(position),
                new EnergyEntity(energy.value() + WorldConstants.DRIED_BODY_ENERGY_VALUE));
        field.cellsMatrix().put(deadBody);
    }

    @Override
    public void makeAMove() {

        var isMoving = isAlive;
        for (int i = 0; isMoving && i < WorldConstants.BOT_MAX_GENES_PER_MOVE; ++i) {

            isMoving = isAlive && genome.runCurrentGene(this);

            energy.changeValue(v -> v + WorldConstants.BOT_RUN_GENE_ENERGY_INCREMENT);
        }
    }

    @Override
    public boolean isFriendly(Bot bot) {
        return genome.isFriendly(bot.genome());
    }
}
