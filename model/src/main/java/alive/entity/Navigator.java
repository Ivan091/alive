package alive.entity;

public interface Navigator {

    void goAhead();

    void rotate(int step);

    void erase();

    boolean isOnPosition(Entity entity);
}
