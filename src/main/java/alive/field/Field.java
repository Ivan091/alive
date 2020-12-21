package alive.field;

import alive.entities.Entity;
import alive.field.cells.CellMatrix;

public interface Field {

    int getWidth();

    int getHeight();

    CellMatrix getCellsMatrix();

    void putEntity(Entity puttingEntity);

    void update();

    int aliveEntitiesCount();
}
