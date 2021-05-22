package alive.organic;

import alive.Entity;
import alive.Healable;


public interface Alive extends Entity, Mortal, Reproducible, Healable {

    void makeAMove();
}
