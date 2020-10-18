package alive.bot.model;

import alive.Field;
import alive.bot.direction.look.BotLookDirection;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.energy.Energy;
import alive.bot.genome.BotGenome;
import alive.bot.genome.Genome;
import alive.bot.position.BotPosition;
import alive.bot.position.Position;

public class Bot implements Movable, Mortal {

    public final Position position;

    public final Energy energy;

    public final Genome genome;

    public final LookDirection lookDirection;

    private boolean isFinished;

    public Bot(Position position, int energyValue, LookDirection lookDirection) {

        this.position = new BotPosition(position.getX(), position.getY());
        this.energy = new BotEnergy(this, energyValue);
        this.genome = new BotGenome(64);
        this.lookDirection = new BotLookDirection(lookDirection.getX(), lookDirection.getY());
    }

    @Override
    public void makeAMove(Field field) {

        while (!isFinished && genome.getCurrentGen().run(this, field)) {
        }

        isFinished = false;
    }

    @Override
    public void Replicate() {

    }

    @Override
    public void Destroy() {

        this.isFinished = true;
    }
}
