package alive.organic;

import alive.field.Field;
import alive.field.PositionCartesian;
import alive.organic.health.HealthOrganic;
import java.util.function.Function;


public class Cell implements Alive, Movable {

    private final Field field;

    private final HealthOrganic health;

    private final PositionCartesian position;

    public Cell(Field field, HealthOrganic health, PositionCartesian position) {
        health.subscribe(this);
        this.field = field;
        this.health = health;
        this.position = position;
    }

    @Override
    public void relocate(PositionCartesian newPosition) {
        field.relocate(position, newPosition);
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
