package alive.entity.cell;

import alive.entity.*;
import alive.entity.genome.Genome;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public final class Cell extends EntityBase implements Alive {

    private final Navigator navigator;

    private final Genome genome;

    private final Color color;

    private int health;

    public Cell(Navigator navigator, Genome genome) {
        this(500, navigator, genome);
    }

    public Cell(int health, Navigator navigator, Genome genome) {
        this(health, navigator, genome, new ColorRGB(255, 255, 255));
    }

    public Cell(int health, Navigator navigator, Genome genome, Color color) {
        super(color);
        this.health = health;
        this.navigator = navigator;
        this.genome = genome;
        this.color = color;
    }

    @Override
    public void makeAMove() {
        heal(-10);
        genome.affect(this);
    }

    @Override
    public boolean isMoving() {
        return navigator.isRegistered(this);
    }

    @Override
    public void heal(int healIncrement) {
        health += healIncrement;
        if (health < 0) die();
        if (health > 1000) replicate();
    }

    @Override
    public void die() {
        new CellDeadBody(health, navigator).register();
    }

    @Override
    public void replicate() {
        var newNavigator = navigator.replicate();
        if (newNavigator.isEmpty()) {
            die();
            return;
        }
        health >>= 2;
        new Cell(health, newNavigator.get(), genome.replicate()).register();
    }

    @Override
    public void register() {
        navigator.register(this);
    }

    @Override
    public void unregister() {
        navigator.unregister();
    }

    @Override
    public int health() {
        return health;
    }

    @Override
    public void repaint(UnaryOperator<Color> modifier) {
        modifier.apply(color);
    }

    @Override
    public void goAhead() {
        navigator.goAhead(this);
    }

    @Override
    public void rotate(int step) {
        navigator.rotate(step);
    }

    private static class CellDeadBody extends EntityBase implements Organic {

        public final Navigator navigator;

        public int health;

        public CellDeadBody(int health, Navigator navigator) {
            this(health, navigator, new ColorRGB(100, 100, 100));
        }

        public CellDeadBody(int health, Navigator navigator, Color color) {
            super(color);
            this.health = health;
            this.navigator = navigator;
        }

        @Override
        public void heal(int healthIncrement) {
            health += healthIncrement;
            if (health <= 0) unregister();
        }

        @Override
        public int health() {
            return health;
        }

        @Override
        public void unregister() {
            navigator.unregister();
        }

        @Override
        public void register() {
            navigator.register(this);
        }
    }
}
