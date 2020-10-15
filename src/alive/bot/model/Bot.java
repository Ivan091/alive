package alive.bot.model;

import alive.Field;
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

    private boolean isFinished;

    public Bot(int x, int y, int energy) {

        position = new BotPosition(x, y);
        this.energy = new BotEnergy(this, energy);
        genome = new BotGenome(64);
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
