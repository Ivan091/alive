package alive.entity;

public interface Alive extends Movable, Positionable, Organic {

    void replicate();

    void die();
}
