package alive.entity;

public interface Visitor {

    default void visit(Visitable visitable) {
    }

    default void visit(Movable movable) {
    }
}