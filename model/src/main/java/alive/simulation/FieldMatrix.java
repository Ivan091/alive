package alive.simulation;

import alive.entity.Entity;


public final class FieldMatrix implements Field {

    private final Entity[][] matrix;

    private final Entity empty;

    public FieldMatrix(int height, int width) {
        matrix = new Entity[height][width];
        empty = new Empty();
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = empty;
            }
        }
    }

    public FieldMatrix(Entity[][] matrix, Entity empty) {
        this.matrix = matrix;
        this.empty = empty;
    }

    @Override
    public void place(Entity entity, Position pos) {
        matrix[pos.y()][pos.x()] = entity;
    }

    @Override
    public Entity search(Position pos) {
        return matrix[pos.y()][pos.x()];
    }

    @Override
    public void empty(Position pos) {
        place(empty, pos);
    }

    @Override
    public void relocate(Position oldPos, Position newPos) {
        place(search(oldPos), newPos);
        empty(oldPos);
    }

    @Override
    public boolean isInBounds(Position pos) {
        return pos.y() >= 0 && pos.x() >= 0 && pos.x() < matrix[0].length && pos.y() < matrix.length;
    }

    @Override
    public boolean isEmpty(Position pos) {
        return isInBounds(pos) && search(pos).equals(empty);
    }
}
