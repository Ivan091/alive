package alive.field;

import alive.field.cell.Cells;

public interface Field {

    int getWidth();

    int getHeight();

    Cells getCells();
}
