package alive.entity;

import alive.simulation.Position;
import java.util.List;


public interface Navigator {

    void goAhead();

    void rotate(int step);

    void erase();

    List<Position> findEmptyAround();

    void register(Entity entity);

    boolean isOnPosition(Entity entity);

    Navigator replicate(Position position);
}
