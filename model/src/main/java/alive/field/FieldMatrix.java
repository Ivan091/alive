package alive.field;

import alive.Entity;


public class FieldMatrix implements Field {

    Entity[][] entities;

    public FieldMatrix(int width, int height) {
        entities = new Entity[height][width];
    }

    @Override
    public Entity get(PositionCartesian position) {
        return entities[position.y()][position.x()];
    }

    @Override
    public boolean place(Entity entity, PositionCartesian position) {
        if (!isInBounds(position)) {
            return false;
        }
        entities[position.y()][position.x()] = entity;
        return true;
    }

    @Override
    public boolean relocate(PositionCartesian oldPosition, PositionCartesian newPosition) {
        if (!isInBounds(newPosition)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isInBounds(PositionCartesian position) {
        return false;
    }
}
