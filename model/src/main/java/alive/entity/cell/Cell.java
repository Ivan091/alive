package alive.entity.cell;

import alive.entity.*;
import alive.genome.Genome;


public final class Cell implements Entity, Alive {

    private final Navigator navigator;

    private final Genome genome;

    private Integer health;

    public Cell(Integer health, Navigator navigator, Genome genome) {
        this.health = health;
        this.navigator = navigator;
        this.genome = genome;
    }

    @Override
    public void makeAMoveIfAlive() {
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
    }
}
