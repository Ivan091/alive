package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;

public interface Cells {

    int getWidth();

    int getHeight();

    /**
     *
     * @param pos position of a cell on the field.
     * @return content in the cell at the position.
     * @throws IllegalArgumentException throws if the position is out of bounds.
     */
    CellContent getCellContent(Position pos) throws IllegalArgumentException;

    /**
     *
     * @param pos position of a cell on the field.
     * @param newCellContent will be assigned to the cell at the position
     * @throws IllegalArgumentException throws if the position is out of bounds.
     */
    void setCellContent(Position pos, CellContent newCellContent) throws IllegalArgumentException;

    /**
     * Sets a content in the cell empty.
     *
     * @param pos position of a cell on field.
     * @throws IllegalArgumentException throws if the position is out of bounds.
     * @see alive.field.cell.content.Empty
     */
    void setEmpty(Position pos) throws IllegalArgumentException;

    /**
     * Checks if the cell is in bounds and empty
     * @param pos checking position on field
     * @return <b>true</b> if position is empty and
     * <b>false</b> if position is out of bounds or not empty
     * @see alive.field.cell.content.Empty
     */
    boolean isEmpty(Position pos);

    boolean isInBounds(Position pos);
}
