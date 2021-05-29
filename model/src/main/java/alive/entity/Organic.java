package alive.entity;

public interface Organic extends Entity {

    void heal(int healthIncrement);

    int health();
}
