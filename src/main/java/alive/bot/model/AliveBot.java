package alive.bot.model;

import alive.bot.condition.BotCondition;
import alive.bot.condition.Condition;
import alive.bot.condition.live.alive.AliveCondition;
import alive.bot.condition.live.alive.BotAliveCondition;
import alive.bot.condition.live.dead.BotDeadCondition;
import alive.bot.direction.look.BotLookDirection;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.energy.Energy;
import alive.bot.genome.BotGenome;
import alive.bot.genome.Genome;
import alive.bot.position.BotPosition;
import alive.bot.position.Position;
import alive.field.Field;

public class AliveBot implements Bot {

    private final Position position;

    private final Energy energy;

    private final Genome genome;

    private final LookDirection lookDirection;

    private final Condition liveCondition;

    public AliveBot(Position position, int energyValue, LookDirection lookDirection) {

        this.position = new BotPosition(position.getX(), position.getY());
        this.energy = new BotEnergy(this, energyValue);
        this.genome = new BotGenome(64);
        this.lookDirection = new BotLookDirection(lookDirection.getX(), lookDirection.getY());
        this.liveCondition = new BotCondition(new BotAliveCondition());
    }

    @Override
    public void makeAMove(Field field) {

        while ((liveCondition.getLiveCondition() instanceof AliveCondition)
                && genome.getCurrentGen().run(this, field)) {
        }
    }

    @Override
    public Condition getLiveCondition() {

        return liveCondition;
    }

    @Override
    public boolean isAlive() {

        return liveCondition.isAlive();
    }

    @Override
    public void Replicate() {

    }

    @Override
    public void Destroy() {

        liveCondition.setLiveCondition(new BotDeadCondition());
    }

    @Override
    public Position getPosition() {

        return position;
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
}
