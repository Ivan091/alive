package alive.bot.model;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.energy.Energy;
import alive.bot.genome.BotGenome;
import alive.bot.genome.Genome;
import alive.bot.position.BotPosition;
import alive.bot.position.Position;
import alive.bot.state.State;
import alive.bot.state.alive.AliveState;
import alive.bot.state.alive.BotAliveState;
import alive.bot.state.dead.BotDeadState;
import alive.field.Field;
import alive.field.cell.content.CellContent;

public class Bot implements Movable, Mortal, CellContent {

    public final Position position;

    public final Energy energy;

    public final Genome genome;

    public final LookDirection lookDirection;

    private State state;

    public Bot(Position position, int energyValue, LookDirection lookDirection) {

        this.position = new BotPosition(position.getX(), position.getY());
        this.energy = new BotEnergy(this, energyValue);
        this.genome = new BotGenome(64);
        this.lookDirection = new BotLookDirection(lookDirection.getX(), lookDirection.getY());
        this.state = new BotAliveState();
    }

    @Override
    public void makeAMove(Field field) {

        while ((state instanceof AliveState) && genome.getCurrentGen().run(this, field)) {
        }
    }

    @Override
    public void Replicate() {

    }

    @Override
    public void Destroy() {

        this.state = new BotDeadState();
    }

    public State getState() {

        return state;
    }
}
