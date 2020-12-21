package alive.field.matrix;

import alive.entities.Entity;
import alive.entities.lifeless.Empty;
import alive.entities.qualities.position.Position;

import java.util.List;
import java.util.Optional;

public interface MatrixEntities {

    Optional<Position> createPositionInside(int x, int y);

    Optional<Position> makePositionToBeInside(Position pos);

    List<Position> findEmptyPositionsAround(Position pos);

    /**
     * @param pos position of a cell on the field.
     * @return content in the cell at the position.
     */
    Entity get(Position pos);

    /**
     * @param newEntity will be assigned to the cell at the position
     * @return the entity, which was in the position before putting.
     */
    Entity put(Entity newEntity);

    /**
     * Makes the position {@link Empty}
     *
     * @param pos position of a cell on field.
     * @return the entity, which was in the position before pulling.
     * @see Entity
     * @see Empty
     */
    Entity pull(Position pos);


    /**
     * @param pos checking position on field
     * @return <b>true</b> if the {@link Entity} in the position is instance of {@link Empty} and
     * <b>false</b> if not.
     * @see Entity
     * @see Empty
     */
    boolean isEmpty(Position pos);

    boolean isInMatrix(Entity entity);

    int getWidth();

    int getHeight();
}
