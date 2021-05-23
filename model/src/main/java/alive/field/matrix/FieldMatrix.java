package alive.field.matrix;

import alive.Entity;
import alive.field.Field;
import alive.field.Position;


public class FieldMatrix implements Field {

    private final Entity[][] entities;

    private final Entity hollow;

    public FieldMatrix(int width, int height, Entity hollow) {
        this.hollow = hollow;
        this.entities = new Entity[height][width];
        for (int i = 0; i < entities.length; i++) {
            for (int j = 0; j < entities[0].length; j++) {
                entities[i][j] = hollow;
            }
        }
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
