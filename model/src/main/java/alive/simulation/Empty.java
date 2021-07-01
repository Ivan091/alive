package alive.simulation;

import alive.entity.*;


public final class Empty extends EntityBase implements Entity {

    public Empty() {
        this(new ColorRGB(0, 0, 0));
    }

    public Empty(Color color) {
        super(color);
    }

    @Override
    public void register() {
    }

    @Override
    public void unregister() {
    }
}
