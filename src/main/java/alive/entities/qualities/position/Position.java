package alive.entities.qualities.position;

import alive.field.cells.CellsMatrix;

import java.util.List;

public interface Position {

    int getX();

    int getY();

    List<Position> getPositionsAround(CellsMatrix cellsMatrix);
}
