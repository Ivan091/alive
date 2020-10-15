package model.bot;

import model.Field;
import model.bot.energy.BotEnergy;
import model.bot.energy.Energy;
import model.bot.genome.BotGenome;
import model.bot.genome.Genome;
import model.bot.position.BotPosition;

public class Bot implements Movable, Mortal {

    public final BotPosition position;

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
