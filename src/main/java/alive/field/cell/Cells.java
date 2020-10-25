package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;

public interface Cells {

    int getWidth();

    int getHeight();

    boolean tryGetCellContent(Position pos, CellContent output);

    boolean trySetCellContent(Position pos, CellContent newCellContent);

    boolean trySetEmpty(Position pos);

    boolean isEmpty(Position pos);

    boolean isInBounds(Position pos);
}
