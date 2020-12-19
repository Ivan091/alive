package alive.entities.alive.bot;

import alive.WorldConstants;
import alive.entities.alive.bot.energy.EnergyAliveBot;
import alive.entities.alive.bot.energy.EnergyBot;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.dead.DeadBotBody;
import alive.entities.qualities.direction.LookDirection;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;
import alive.field.Field;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class BotAlive implements Bot {

    private final Field field;

    private final EnergyBot energy;

    private final LookDirection lookDirection;

    private final Genome genome;

    private Position position;

    private boolean isAlive = true;

    public BotAlive(Field field, Position position, EnergyBot energy, LookDirection lookDirection, Genome genome) {

        this.field = field;
        this.position = position;

        energy.subscribeMortal(this);
        this.energy = energy;

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
        var newBotEnergy = new EnergyAliveBot(newBotEnergyValue);
        energy.setEnergyValue(newBotEnergyValue);

        var newBot = new BotAlive(field, newBotPos, newBotEnergy,
                lookDirection.getOpposite(), genome.replicate());

        field.putEntity(newBot);
    }

    @Override
    public void destroy() {

        isAlive = false;
        var deadBody = new DeadBotBody(new PositionEntity(position), new EnergyEntity(energy));
        field.getCellsMatrix().putEntity(deadBody);
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
    public boolean isAlive() {

        return isAlive;
    }

    @Override
    public Field getField() {

        return field;
    }

    @Override
    public EnergyBot getEnergy() {

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
