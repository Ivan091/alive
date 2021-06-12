package alive.simulation;

import alive.entity.Entity;
import alive.entity.EntityBase;
import java.awt.*;


public final class Empty extends EntityBase implements Entity {

    public Empty() {
        this(Color.BLACK);
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
