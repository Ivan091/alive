package alive.simulation;

import alive.entity.Entity;


public final class FieldMatrix implements Field {

    private final Entity[][] matrix;

    private final Entity empty;

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

    @Override
    public Entity[][] state() {
        return matrix;
    }
}
