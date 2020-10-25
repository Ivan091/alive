package alive.field;

import alive.bot.model.Alive;
import alive.field.cell.Cells;

public interface Field {

    int getWidth();

    int getHeight();

    Cells getCells();

    void addNewAlive(Alive newAlive);
}
