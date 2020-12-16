package alive.field.cells;

import alive.bot.position.Position;
import alive.field.cells.content.EmptyEntity;
import alive.field.cells.content.Entity;

import java.util.Optional;

public interface CellsMatrix {

    /**
     * @param pos position of a cell on the field.
     * @return content in the cell at the position.
     */
    Entity getEntity(Position pos);

    /**
     * @param newEntity will be assigned to the cell at the position
     */
    void addEntity(Entity newEntity);

    /**
     * Calls eraseFromField method from cell's content.
     * Sets a content in the cell empty.
     *
     * @param pos position of a cell on field.
     * @see EmptyEntity
     */
    void addEmpty(Position pos);

    /**
     * Calls eraseFromField method from cell's content.
     *
     * @param pos position on field
     */
    void finalizeEntity(Position pos);

    /**
     * Checks if the cell is in bounds and empty
     *
     * @param pos checking position on field
     * @return <b>true</b> if position is empty and
     * <b>false</b> if position is out of bounds or not empty
     * @see EmptyEntity
     */
    boolean isEmpty(Position pos);

    Optional<Position> createPositionOnField(int x, int y);

    Optional<Position> createPositionOnField(Position pos);

    int getWidth();

    int getHeight();
}
