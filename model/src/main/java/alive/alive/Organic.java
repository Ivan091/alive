package alive.alive;

import alive.alive.health.Healable;


public interface Organic extends Mortal, Healable {

    Organic reproduce();
}
