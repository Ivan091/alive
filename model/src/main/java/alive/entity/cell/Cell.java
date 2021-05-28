package alive.entity.cell;

import alive.entity.*;
import alive.genome.Genome;
import java.util.Random;


public final class Cell implements Entity, Alive {

    private final Navigator navigator;

    private final Genome genome;

    private int health;

    public Cell(Navigator navigator, Genome genome) {
        this(500, navigator, genome);
    }

    public Cell(int health, Navigator navigator, Genome genome) {
        this.health = health;
        this.navigator = navigator;
        navigator.register(this);
        this.genome = genome;
    }

    @Override
    public void makeAMove() {
        genome.affect(this);
    }

    @Override
    public boolean isAlive() {
        return navigator.isOnPosition(this);
    }

    @Override
    public void goAhead() {
        navigator.goAhead();
    }

    @Override
    public void rotate(int step) {
        navigator.rotate(step);
    }

    @Override
    public void heal(int healIncrement) {
        health += healIncrement;
        if (health < 0) die();
        if (health > 1000) replicate();
    }

    @Override
    public int health() {
        return health;
    }

    @Override
    public void die() {
        navigator.erase();
    }

    @Override
    public void replicate() {
        var poss = navigator.findEmptyAround();
        if (poss.size() == 0) {
            die();
            return;
        }
        var r = new Random();
        health = (health * 9 / 10) >> 1;
        var newPos = poss.get(r.nextInt(poss.size()));
        var newNavigator = navigator.replicate(newPos);
        newNavigator.register(new Cell(health, newNavigator, genome.replicate()));
    }
}
