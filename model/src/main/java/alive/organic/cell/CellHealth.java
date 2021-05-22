package alive.organic.cell;

import alive.organic.Organic;
import alive.organic.health.Healable;
import alive.organic.health.HealableObserver;
import java.util.function.Function;


public class CellHealth implements HealableObserver {

    private final Healable health;

    private Organic organic;

    public CellHealth(Healable health) {
        this.health = health;
    }

    @Override
    public void subscribe(Organic observedObject) {
        organic = observedObject;
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
