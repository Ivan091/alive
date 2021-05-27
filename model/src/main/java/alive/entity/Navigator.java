package alive.entity;

public interface Navigator {

    void goAhead();

    void rotate(int step);

    void erase();

    void register(Entity entity);

    boolean isOnPosition(Entity entity);
}
