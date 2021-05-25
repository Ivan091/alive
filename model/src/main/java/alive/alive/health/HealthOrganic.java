package alive.alive.health;

import alive.Observer;
import alive.alive.Organic;


public interface HealthOrganic extends Observer<Organic>, Health {

    HealthOrganic reproduce();
}
