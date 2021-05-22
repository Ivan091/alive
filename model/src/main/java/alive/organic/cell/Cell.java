package alive.organic.cell;

import alive.organic.Alive;
import alive.organic.Navigable;
import alive.organic.health.HealableObserver;
import java.util.function.Function;


public class Cell implements Alive, Navigable {

    private final Navigable navigator;

    private final HealableObserver health;

    public Cell(Navigable navigator, HealableObserver health) {
        this.navigator = navigator;
        health.subscribe(this);
        this.health = health;
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
