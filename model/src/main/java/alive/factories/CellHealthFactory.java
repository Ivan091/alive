package alive.factories;

import alive.organic.Organic;
import alive.organic.cell.CellHealth;
import alive.organic.health.Health;
import alive.organic.health.HealthBasic;


public class CellHealthFactory implements ObserverFactory<Health, Organic> {

    private final Integer initHealth;

    public CellHealthFactory(Integer initHealth) {
        this.initHealth = initHealth;
    }

    @Override
    public Health create(Organic observedObj) {
        return new CellHealth(new HealthBasic(initHealth), observedObj);
    }
}
