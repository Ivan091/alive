package alive.config;

import alive.organic.Organic;
import alive.organic.health.Health;


public interface HealthFactory {

    Health createCellHealth(Integer initHealth, Organic organicOwner);
}
