package alive.entity;

public interface Alive extends Entity, Movable, Positionable, Organic {

    void replicate();

    void die();
}
