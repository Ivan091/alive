package alive.organic.cell;

import alive.config.HealthFactory;
import alive.organic.Alive;
import alive.organic.Navigator;
import alive.organic.health.Health;
import java.util.function.Function;


public class Cell implements Alive, Navigator {

    private final Navigator navigator;

    private final Health health;

    public Cell(Navigator navigator, HealthFactory health) {
        this.health = health.createCellHealth(100, this);
        this.navigator = navigator;
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

    @Override
    public void goAhead() {
        navigator.goAhead();
    }

    @Override
    public void rotate(int steps) {
        navigator.rotate(steps);
    }
}
