package alive.entity;

public interface Alive extends Entity {

    void die();

    void replicate();

    void goAhead();

    void rotate(int step);

    void heal(int healthIncrement);

    int health();
}
