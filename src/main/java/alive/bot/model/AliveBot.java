package alive.bot.model;

import alive.WorldConstants;
import alive.bot.condition.BotLiveCondition;
import alive.bot.condition.LiveCondition;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.energy.Energy;
import alive.bot.genome.Genome;
import alive.bot.position.Position;
import alive.field.Field;
import alive.field.cells.content.DeadBotBody;

public class AliveBot implements Bot {

    private final Field field;

    private final Energy energy;

    private final LookDirection lookDirection;

    private final Genome genome;

    private final LiveCondition liveCondition;

    private Position position;

    public AliveBot(Field field, Position position, int energyValue, LookDirection lookDirection, Genome genome) {

        this.field = field;
        this.position = position;
        this.energy = new BotEnergy(this, energyValue);
        this.genome = genome;
        this.lookDirection = lookDirection;
        this.liveCondition = new BotLiveCondition();
    }

    @Override
    public void makeAMove() {

        var isMoving = true;
        for (int i = 0; isMoving && i < WorldConstants.BOT_MAX_GENES_PER_MOVE; ++i) {

            isMoving = isAlive() && genome.getCurrentGene().run(this);
            energy.incrementEnergyValue(WorldConstants.BOT_RUN_GENE_ENERGY_INCREMENT);
        }
    }

    @Override
    public void replicate() {

        Position newBotPos;

        var lookingPos = this.lookDirection.getOpposite().getLookingPos(position);
        if (field.getCells().isInBoundsAndEmpty(lookingPos)) {
            newBotPos = lookingPos;
        } else {
            var possiblePosition = position.getPositionsAround()
                    .stream().filter(field.getCells()::isInBoundsAndEmpty).findAny();

            if (possiblePosition.isPresent()) {
                newBotPos = possiblePosition.get();
            } else {
                destroy();
                return;
            }
        }

        var newBotEnergy = this.getEnergyValue() >> 1;
        this.energy.setEnergyValue(newBotEnergy);

        var newBot = new AliveBot(field, newBotPos, newBotEnergy,
                this.lookDirection.getOpposite(), genome.replicate());

        field.addNewAlive(newBot);
    }

    @Override
    public void destroy() {

        liveCondition.makeDead();
        var deadBody = new DeadBotBody(getEnergyValue() + WorldConstants.DRIED_BODY_ENERGY_VALUE);
        field.getCells().setContent(position, deadBody);
    }

    @Override
    public boolean isAlive() {

        return liveCondition.isAlive();
    }

    @Override
    public LiveCondition getLiveCondition() {

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
