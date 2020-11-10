package alive.bot.model;

import alive.WorldConstants;
import alive.bot.condition.*;
import alive.bot.condition.live.LiveConditions;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.*;
import alive.bot.genome.Genome;
import alive.bot.position.Position;
import alive.field.Field;
import alive.field.cell.content.DeadBotBody;

import java.util.Random;

public class AliveBot implements Bot {

    private final Field field;

    private Position position;

    private final Energy energy;

    private final LookDirection lookDirection;

    private final Genome genome;

    private final Condition liveCondition;

    public AliveBot(Field field, Position position, int energyValue, LookDirection lookDirection, Genome genome) {

        this.field = field;
        this.position = position;
        this.energy = new BotEnergy(this, energyValue);
        this.genome = genome;
        this.lookDirection = lookDirection;
        this.liveCondition = new BotCondition(LiveConditions.ALIVE);
    }

    @Override
    public void makeAMove() {

        var isMoving = true;
        for (int i = 0; isMoving && i < WorldConstants.BOT_MAX_GENES_PER_MOVE; ++i) {

            isMoving = isAlive() && genome.getCurrentGene().run(this);
            energy.incrementEnergyValue(-WorldConstants.BOT_RUN_GEN_COST);
        }
    }

    @Override
    public Void replicate() {

        Position newBotPos;

        var lookingPos = this.lookDirection.getLookingPos(position);
        if (field.getCells().isEmpty(lookingPos)) {
            newBotPos = lookingPos;
        } else {
            var possiblePositions = position.getPositionsAround()
                    .stream().filter(x -> field.getCells().isEmpty(x)).toArray();

            if (possiblePositions.length < 1) {
                destroy();
                return null;
            } else {
                newBotPos = (Position) possiblePositions[new Random().nextInt(possiblePositions.length)];
            }
        }

        var newBotEnergy = this.getEnergyValue() >> 1;
        this.energy.setEnergyValue(newBotEnergy);

        var newBot = new AliveBot(field, newBotPos, newBotEnergy,
                this.lookDirection.getOpposite(), genome.replicate());

        field.addNewAlive(newBot);
        return null;
    }

    @Override
    public void destroy() {

        liveCondition.setLiveCondition(LiveConditions.DEAD);
        var deadBody = new DeadBotBody(getEnergyValue() + WorldConstants.DRIED_BODY_ENERGY_VALUE);
        field.getCells().setCellContent(position, deadBody);
    }

    @Override
    public boolean isAlive() {

        return liveCondition.isAlive();
    }

    @Override
    public Condition getLiveCondition() {

        return liveCondition;
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
    public Energy getEnergy() {

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
    public void eraseFromField() {

        destroy();
    }

    @Override
    public int getEnergyValue() {

        return energy.getEnergyValue();
    }
}
