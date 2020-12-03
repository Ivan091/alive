package alive.field.cells;

import alive.bot.position.Position;
import alive.field.cells.content.Content;

public interface CellsMatrix {

    /**
     * @param pos position of a cell on the field.
     * @return content in the cell at the position.
     */
    Content getContent(Position pos);

    /**
     * @param pos        position of a cell on the field.
     * @param newContent will be assigned to the cell at the position
     */
    void setContent(Position pos, Content newContent);

    /**
     * Calls eraseFromField method from cell's content.
     * Sets a content in the cell empty.
     *
     * @param pos position of a cell on field.
     * @see alive.field.cells.content.Empty
     */
    void setEmpty(Position pos);

    /**
     * Calls eraseFromField method from cell's content.
     *
     * @param pos position on field
     */
    void destroy(Position pos);

    /**
     * Checks if the cell is in bounds and empty
     *
     * @param pos checking position on field
     * @return <b>true</b> if position is empty and
     * <b>false</b> if position is out of bounds or not empty
     * @see alive.field.cells.content.Empty
     */
    boolean isEmpty(Position pos);

    boolean isInBounds(Position pos);

    boolean isInBoundsAndEmpty(Position pos);

    int getWidth();

    int getHeight();
}
