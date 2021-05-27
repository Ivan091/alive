package alive.simulation;

import alive.entity.Entity;


public final class Empty implements Entity {

    @Override
    public void makeAMoveIfAlive() {
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
