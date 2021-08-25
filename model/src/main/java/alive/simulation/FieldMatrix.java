package alive.simulation;

import alive.entity.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.UnaryOperator;


public final class FieldMatrix implements Field {

    private final Entity[][] matrix;

    private final Entity empty;

    public FieldMatrix(int width, int height) {
        empty = new Empty();
        matrix = new Entity[height][width];
        for (var row : matrix) {
            Arrays.fill(row, empty);
        }
    }

    @Override
    public void place(Entity entity, Position pos) {
        matrix[pos.y()][Math.floorMod(pos.x(), matrix[0].length)] = entity;
    }

    @Override
    public Entity search(Position pos) {
        return matrix[pos.y()][Math.floorMod(pos.x(), matrix[0].length)];
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
        return pos.y() >= 0 && pos.y() < matrix.length;
    }

    @Override
    public boolean isEmpty(Position pos) {
        return isInBounds(pos) && search(pos).equals(empty);
    }

    @Override
    public Entity[][] state() {
        return matrix;
    }

    private static final class Empty implements Entity {

        private final Color color;

        public Empty() {
            this(new ColorDefault(0, 0, 0));
        }

        public Empty(Color color) {
            this.color = color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(color);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Empty empty = (Empty) o;
            return Objects.equals(color, empty.color);
        }

        @Override
        public void repaint(UnaryOperator<Color> modifier) {
            modifier.apply(color);
        }

        @Override
        public Color color() {
            return color;
        }

        @Override
        public void register() {
        }

        @Override
        public void unregister() {
        }

        @Override
        public boolean isRegistered() {
            return false;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
}
