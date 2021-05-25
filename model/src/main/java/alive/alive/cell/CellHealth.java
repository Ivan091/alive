package alive.alive.cell;

import alive.alive.Organic;
import alive.alive.health.Healable;
import alive.alive.health.HealthOrganic;
import java.util.function.Function;


public class CellHealth implements HealthOrganic {

    private final Healable health;

    private Organic organic;

    public CellHealth(Healable health, Organic organicOwner) {
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

    @Override
    public void subscribe(Organic observed) {
        organic = observed;
    }

    @Override
    public HealthOrganic reproduce() {
        return null;
    }
}
