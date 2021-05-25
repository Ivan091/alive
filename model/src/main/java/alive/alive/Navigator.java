package alive.alive;

import alive.Entity;
import alive.Observer;
import java.util.Optional;


public interface Navigator extends Observer<Entity>, Navigable {

    Optional<Navigator> reproduce();
}
