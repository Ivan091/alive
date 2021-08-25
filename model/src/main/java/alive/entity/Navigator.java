package alive.entity;

import java.util.Optional;


public interface Navigator {

    void goAhead(Entity entity);

    void rotate(int step);

    void register(Entity entity);

    void unregister();

    boolean isRegistered(Entity entity);

    Optional<Entity> look();

    Optional<Navigator> replicate();
}
