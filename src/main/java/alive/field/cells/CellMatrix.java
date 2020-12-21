package alive.field.cells;

import alive.entities.Entity;
import alive.entities.lifeless.EmptyEntity;
import alive.entities.qualities.position.Position;

import java.util.List;
import java.util.Optional;

public interface CellMatrix {

    Optional<Position> createPositionOnField(int x, int y);

    Optional<Position> createPositionOnField(Position pos);

    List<Position> findEmptyPositionsAround(Position pos);

    /**
     * @param pos position of a cell on the field.
     * @return content in the cell at the position.
     */
    Entity getEntity(Position pos);

    /**
     * @param newEntity will be assigned to the cell at the position
     */
    void putEntity(Entity newEntity);

    /**
     * Calls eraseFromField method from cell's content.
     * Sets a content in the cell empty.
     *
     * @param pos position of a cell on field.
     * @see EmptyEntity
     */
    void putEmpty(Position pos);


    /**
     * Checks if the cell is in bounds and empty
     *
     * @param pos checking position on field
     * @return <b>true</b> if position is empty and
     * <b>false</b> if position is out of bounds or not empty
     * @see EmptyEntity
     */
    boolean isEmpty(Position pos);

    int getWidth();

    int getHeight();
}
