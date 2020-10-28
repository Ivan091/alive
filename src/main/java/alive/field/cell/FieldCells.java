package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;
import alive.field.cell.content.Empty;

public class FieldCells implements Cells {

    private static final CellContent empty = new Empty();

    private final CellContent[][] cellsContent;

    public FieldCells(int height, int width) {

        cellsContent = new CellContent[width][height];

        for (var i = 0; i < width; ++i) {
            for (var j = 0; j < height; ++j) {
                cellsContent[i][j] = empty;
            }
        }
    }

    @Override
    public CellContent getCellContent(Position pos) {

        if (!isInBounds(pos)) {
            throw new IllegalArgumentException(pos.toString() + " was out of bounds of the field");
        }
        return getCellContentByPos(pos);
    }

    @Override
    public void setCellContent(Position pos, CellContent newCellContent) {

        if (!isInBounds(pos)) {
            throw new IllegalArgumentException(pos.toString() + " was out of bounds of the field");
        }
        cellsContent[pos.getX()][pos.getY()] = newCellContent;
    }

    @Override
    public void setEmpty(Position pos) {

        if (!isInBounds(pos)) {
            throw new IllegalArgumentException(pos.toString() + " was out of bounds of the field");
        }
        cellsContent[pos.getX()][pos.getY()].eraseFromField();
        cellsContent[pos.getX()][pos.getY()] = empty;
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

        pos.setX((pos.getX()) % getWidth());

        if (pos.getX() < 0) {
            pos.setX(pos.getX() + getWidth());
        }
    }

    @Override
    public int getWidth() {

        return cellsContent.length;
    }

    @Override
    public int getHeight() {

        return cellsContent[0].length;
    }
}
