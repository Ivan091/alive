package alive.organic.bot;

import alive.Healable;
import alive.Observer;
import alive.organic.Organic;
import java.util.function.Function;


public class HealthOrganic implements Observer<Organic>, Healable {

    private final Healable health;

    private Organic organic;

    public HealthOrganic(Healable health) {
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
