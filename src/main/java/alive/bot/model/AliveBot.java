package alive.bot.model;

import alive.WorldConstants;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.*;
import alive.bot.genome.Genome;
import alive.bot.position.EntityPosition;
import alive.bot.position.Position;
import alive.field.Field;
import alive.field.cells.content.DeadBotBody;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class AliveBot implements Bot {

    private final Field field;

    private final BotEnergy energy;

    private final LookDirection lookDirection;

    private final Genome genome;

    private Position position;

    private boolean isAlive = true;

    public AliveBot(Field field, Position position, int energyValue, LookDirection lookDirection, Genome genome) {

        this.field = field;
        this.position = position;
        this.energy = new AliveBotEnergy(this, energyValue);
        this.genome = genome;
        this.lookDirection = lookDirection;
    }

    @Override
    public void makeAMove() {

        var isMoving = isAlive();
        for (int i = 0; isMoving && i < WorldConstants.BOT_MAX_GENES_PER_MOVE; ++i) {

            isMoving = isAlive() && genome.runCurrentGene(this);
            energy.incrementEnergyValue(WorldConstants.BOT_RUN_GENE_ENERGY_INCREMENT);
        }
    }

    @Override
    public void replicate() {

        if (!isAlive) {
            return;
        }

        Position newBotPos;

        var positionBehindOfBot = field.getCellsMatrix().createPositionOnField(lookDirection.getOpposite().getLookingPos(position));

        if (positionBehindOfBot.isPresent() && field.getCellsMatrix().isEmpty(positionBehindOfBot.get())) {
            newBotPos = positionBehindOfBot.get();
        } else {
            var possiblePositions = position.getPositionsAround(field.getCellsMatrix())
                    .stream()
                    .filter(field.getCellsMatrix()::isEmpty)
                    .collect(Collectors.toList());
            if (possiblePositions.size() == 0) {
                destroy();
                return;
            } else {
                newBotPos = possiblePositions.get(ThreadLocalRandom.current().nextInt(possiblePositions.size()));
            }

        }
        energy.setEnergyValue(energy.getEnergyValue() - genome.length() * WorldConstants.GENE_REPLICATION_COST);
        var newBotEnergy = energy.getEnergyValue() >> 1;
        energy.setEnergyValue(newBotEnergy);

        var newBot = new AliveBot(field, newBotPos, newBotEnergy,
                lookDirection.getOpposite(), genome.replicate());

        field.addNewAlive(newBot);
    }

    @Override
    public void destroy() {

        isAlive = false;
        var deadBody = new DeadBotBody(new EntityPosition(position), new EntityEnergy(energy));
        field.getCellsMatrix().addEntity(deadBody);
    }


    @Override
    public boolean isAlive() {

        return isAlive;
    }

    @Override
    public Position getPosition() {

        return position;
    }

    @Override
    public void setPosition(Position newPos) {

        position = newPos;
    }

    @Override
    public Field getField() {

        return field;
    }

    @Override
    public BotEnergy getEnergy() {

        return energy;
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
        return field.getCellsMatrix().createPositionOnField(lookDirection.getLookingPos(position));
    }

    @Override
    public void finalizeBeforeErasingFromField() {
        isAlive = false;
    }
}
