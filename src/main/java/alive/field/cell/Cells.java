package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;

public interface Cells {

    int getWidth();

    int getHeight();

    CellContent getCellContent(Position pos) throws IllegalArgumentException;

    void setCellContent(Position pos, CellContent newCellContent) throws IllegalArgumentException;

    void setEmpty(Position pos) throws IllegalArgumentException;

    boolean isEmpty(Position pos);

    boolean isInBounds(Position pos);
}
