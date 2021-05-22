package alive.field;

import alive.Entity;


public class FieldMatrix implements Field {

    Entity[][] entities;

    Hollow hollow = new Hollow();

    public FieldMatrix(int width, int height) {
        entities = new Entity[height][width];
    }

    @Override
    public Entity search(Position position) {
        return entities[position.y()][position.x()];
    }

    @Override
    public void place(Entity entity, Position position) {
        entities[position.y()][position.x()] = entity;
    }

    @Override
    public void relocate(Position oldPosition, Position newPosition) {
        place(search(oldPosition), newPosition);
        place(hollow, oldPosition);
    }

    @Override
    public boolean isInBounds(Position position) {
        return position.x() >= 0 && position.x() < entities[0].length && position.y() >= 0 && position.y() < entities.length;
    }

    @Override
    public boolean isHollow(Position position) {
        return isInBounds(position) && search(position).equals(hollow);
    }
}
