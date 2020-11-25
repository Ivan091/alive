package alive.field;

import alive.bot.model.Alive;
import alive.field.cells.CellsMatrix;

public interface Field {

    int getWidth();

    int getHeight();

    CellsMatrix getCells();

    void addNewAlive(Alive newAlive);
}
