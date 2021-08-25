package alive.entity;

import java.util.Optional;


public interface Positionable {

    void goAhead();

    void rotate(int step);

    Optional<Entity> look();
}
