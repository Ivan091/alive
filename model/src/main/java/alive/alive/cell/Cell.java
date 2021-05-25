package alive.alive.cell;

import alive.alive.Alive;
import alive.alive.Navigator;
import alive.alive.genome.Genome;
import alive.alive.health.HealthOrganic;
import java.util.function.Function;


public class Cell implements Alive {

    private final Navigator navigator;

    private final HealthOrganic health;

    private final Genome genome;

    public Cell(Navigator navigator, HealthOrganic health, Genome genome) {
        this.genome = genome;
        this.health = health;
        health.subscribe(this);
        this.navigator = navigator;
        navigator.subscribe(this);
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
        navigator.subscribe();
    }

    @Override
    public void reproduce() {
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
