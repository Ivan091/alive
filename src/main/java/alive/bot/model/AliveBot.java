package alive.bot.model;

import alive.Randomize;
import alive.WorldConstants;
import alive.bot.condition.BotCondition;
import alive.bot.condition.Condition;
import alive.bot.condition.live.LiveConditions;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.energy.Energy;
import alive.bot.genome.Genome;
import alive.bot.position.Position;
import alive.field.Field;
import alive.field.cell.content.DeadBotBody;

public class AliveBot implements Bot {

    private final Field field;

    private final Position position;

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

        while (isAlive() && genome.getCurrentGen().run(this)) {

            energy.changeEnergyValue(-WorldConstants.BOT_RUN_GEN_COST);
        }
    }

    @Override
    public void replicate() {

        Position newBotPos;

        var lookingPos = this.lookDirection.getLookingPos(position);
        if (field.getCells().isEmpty(lookingPos)) {
            newBotPos = lookingPos;
        } else {
            var possiblePos = position.getPositionsAround()
                    .stream().filter(x -> field.getCells().isEmpty(x)).toArray();

            if (possiblePos.length == 0) {
                destroy();
                return;
            } else {
                newBotPos = (Position) possiblePos[Randomize.nextInt(0, possiblePos.length)];
            }
        }

        this.getEnergy().changeEnergyValue(x -> x >> 1);
        var newBotEnergy = this.getEnergyValue();

        var newBot = new AliveBot(field, newBotPos, newBotEnergy,
                this.lookDirection.getOpposite(), genome.replicate());

        field.addNewAlive(newBot);
    }

    @Override
    public void destroy() {

        liveCondition.setLiveCondition(LiveConditions.DEAD);
        var deadBody = new DeadBotBody(getEnergyValue() + WorldConstants.DRIED_BODY_ENERGY_VALUE);
        field.getCells().trySetCellContent(position, deadBody);
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
    public int getEnergyValue() {

        return energy.getEnergyValue();
    }
}
