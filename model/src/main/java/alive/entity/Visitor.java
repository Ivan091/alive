package alive.entity;

public interface Visitor {

    default void visit(Visitable visitable) {
    }

    default void visit(Entity entity) {
        visit((Visitable) entity);
    }

    default void visit(Organic organic) {
        visit((Entity) organic);
    }

    default void visit(Movable movable) {
        visit((Organic) movable);
    }

    default void visit(Alive alive) {
        visit((Movable) alive);
    }
}