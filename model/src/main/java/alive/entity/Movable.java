package alive.entity;

public interface Movable extends Entity {

    default void accept(Visitor visitor) {
        visitor.visit(this);
    }

    void makeAMove();

    boolean isMoving();
}
