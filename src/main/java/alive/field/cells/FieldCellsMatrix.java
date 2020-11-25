package alive.field.cells;

import alive.bot.position.Position;
import alive.field.cells.content.Content;
import alive.field.cells.content.Empty;

public class FieldCellsMatrix implements CellsMatrix {

    private static final Content empty = new Empty();

    private final Content[][] cellsMatrix;

    public FieldCellsMatrix(int height, int width) {

        cellsMatrix = new Content[width][height];

        for (var i = 0; i < width; ++i) {
            for (var j = 0; j < height; ++j) {
                cellsMatrix[i][j] = empty;
            }
        }
    }

    @Override
    public Content getContent(Position pos) {

        return cellsMatrix[pos.getX()][pos.getY()];
    }

    @Override
    public void setContent(Position pos, Content newContent) {

        cellsMatrix[pos.getX()][pos.getY()] = newContent;
    }

    @Override
    public void setEmpty(Position pos) {

        getContent(pos).eraseFromField();
        setContent(pos, empty);
    }

    @Override
    public boolean isEmpty(Position pos) {

        return getContent(pos).equals(empty);
    }

    @Override
    public boolean isInBounds(Position pos) {

        if (pos.getY() >= 0 && pos.getY() < getHeight()) {
            modulate(pos);
            return true;
        }
        return false;
    }

    @Override
    public boolean isInBoundsAndEmpty(Position pos) {
        return isInBounds(pos) && isEmpty(pos);
    }

    private void modulate(Position pos) {

        pos.setX((pos.getX()) % getWidth());

        if (pos.getX() < 0) {
            pos.setX(pos.getX() + getWidth());
        }
    }

    @Override
    public int getWidth() {

        return cellsMatrix.length;
    }

    @Override
    public int getHeight() {

        return cellsMatrix[0].length;
    }
}
