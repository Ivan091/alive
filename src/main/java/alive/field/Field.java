package alive.field;

import alive.entities.Entity;
import alive.field.cells.CellsMatrix;

public interface Field {

    int getWidth();

    int getHeight();

    CellsMatrix getCellsMatrix();

    void putEntity(Entity puttingEntity);

    void update();

    int aliveCount();
}
