package alive.field;

import alive.Entity;


public interface Field {

    void register(Entity entity);

    Entity get(Position position);
}
