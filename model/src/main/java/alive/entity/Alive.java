package alive.entity;

public interface Alive extends Movable, Positionable {

    void replicate();

    void die();

    boolean isFriendly(Alive other);
}
