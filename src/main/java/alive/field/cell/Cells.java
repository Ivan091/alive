package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;

public interface Cells {

    int getWidth();

    int getHeight();

    CellContent getCellContent(Position pos);

    void setCellContent(Position pos, CellContent newCellContent);

    void setEmpty(Position pos);

    boolean isEmpty(Position pos);

    boolean isInBounds(Position pos);
}
