package alive.entity.cell;

import alive.entity.*;
import java.awt.*;


public class CellDeadBody extends EntityBase implements Organic {

    public final Navigator navigator;

    public int health;

    public CellDeadBody(int health, Navigator navigator) {
        this(health, navigator, Color.GRAY);
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
