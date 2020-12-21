package alive.field;

import alive.entities.Entity;
import alive.field.matrix.MatrixEntities;

public interface Field {

    void update();

    void putEntity(Entity puttingEntity);

    MatrixEntities getCellsMatrix();

    int aliveEntitiesCount();

    int getWidth();

    int getHeight();
}
