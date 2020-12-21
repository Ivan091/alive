package alive.entities;

import alive.entities.qualities.position.Position;

public abstract class EntityAbstract implements Entity {

    protected Position position;

    public EntityAbstract(Position position) {
        this.position = position;
    }

    @Override
    public final Position getPosition() {
        return position;
    }

    @Override
    public final void setPosition(Position position) {
        this.position = position;
    }
}
