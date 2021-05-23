package alive.organic.cell;

import alive.organic.Organic;
import alive.organic.health.Health;
import java.util.function.Function;


public class CellHealth implements Health {

    private final Health health;

    private final Organic organic;

    public CellHealth(Health health, Organic organicOwner) {
        this.health = health;
        this.organic = organicOwner;
    }

    @Override
    public void heal(Function<Integer, Integer> healthModifier) {
        health.heal(healthModifier);
        if (health() <= 0) {
            organic.die();
        } else if (health() >= 1000) {
            organic.reproduce();
        }
    }

    @Override
    public Integer health() {
        return health.health();
    }
}
