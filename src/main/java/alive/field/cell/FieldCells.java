package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;
import alive.field.cell.content.Empty;

public class FieldCells implements Cells {

    private static final CellContent empty = new Empty();

    private final CellContent[][] cellsContent;

    public FieldCells(int height, int width) {

        cellsContent = new CellContent[height][width];

        for (var i = 0; i < height; ++i) {
            for (var j = 0; j < width; ++j) {
                cellsContent[i][j] = empty;
            }
        }
    }

    @Override
    public boolean tryGetCellContent(Position pos, CellContent output) {

        if (isInBounds(pos)) {
            output = getCellContentByPos(pos);
            return true;
        }
        return false;
    }

    @Override
    public boolean trySetCellContent(Position pos, CellContent newCellContent) {

        if (isInBounds(pos)) {
            cellsContent[pos.getX()][pos.getY()] = newCellContent;
            return true;
        }
        return false;
    }

    @Override
    public boolean trySetEmpty(Position pos) {

        if (isInBounds(pos)) {
            cellsContent[pos.getX()][pos.getY()] = empty;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty(Position pos) {

        if (isInBounds(pos)) {
            return getCellContentByPos(pos).equals(empty);
        }
        return false;
    }

    @Override
    public boolean isInBounds(Position pos) {

        if (pos.getY() >= 0 && pos.getY() < getHeight()) {
            modulate(pos);
            return true;
        }
        return false;
    }

    private CellContent getCellContentByPos(Position pos) {

        return cellsContent[pos.getX()][pos.getY()];
    }

    private void modulate(Position pos) {

        pos.setX((pos.getX() + getWidth()) % getWidth());
    }

    @Override
    public int getWidth() {

        return cellsContent[0].length;
    }

    @Override
    public int getHeight() {

        return cellsContent.length;
    }
}
