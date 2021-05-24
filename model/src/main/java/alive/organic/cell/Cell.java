package alive.organic.cell;

import alive.organic.Alive;
import alive.organic.health.Healable;
import alive.organic.health.HealthOrganic;
import java.util.function.Function;


public class Cell implements Alive {

    private final Navigator navigator;

    private final Healable health;

    public Cell(Navigator navigator, HealthOrganic health) {
        health.subscribe(this);
        this.health = health;
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
        navigator.die();
    }

    @Override
    public boolean isAlive() {
        return navigator.isAlive();
    }

    @Override
    public Void reproduce() {
        return null;
    }

    @Override
    public void makeAMove() {
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
