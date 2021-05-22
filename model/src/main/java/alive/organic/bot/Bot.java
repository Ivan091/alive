package alive.organic.bot;

import alive.Healable;
import alive.field.Field;
import alive.field.PositionCartesian;
import alive.organic.Alive;
import alive.organic.Movable;
import java.util.function.Function;


public class Bot implements Alive, Movable {

    private final Field field;

    private final Healable health;

    private PositionCartesian position;

    public Bot(Field field, Healable health, PositionCartesian position) {
        this.field = field;
        this.health = health;
        this.position = position;
    }

    @Override
    public void relocate(PositionCartesian newPosition) {
        if (field.relocate(position, newPosition)) {
            position = newPosition;
        }
    }

    @Override
    public void heal(Function<Integer, Integer> healthModifier) {
        health.heal(healthModifier);
    }

    @Override
    public Integer health() {
        return health.health();
    }

    @Override
    public void die() {
    }

    @Override
    public void makeAMove() {
    }

    @Override
    public void reproduce() {
    }
}
