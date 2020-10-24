package alive.field.cell;

import alive.bot.position.Position;
import alive.field.cell.content.CellContent;
import alive.field.cell.content.Empty;

import java.util.Arrays;

public class FieldCells implements Cells {

    private static final CellContent empty = new Empty();

    private CellContent[][] cellContents;

    public FieldCells(int height, int width) {

        cellContents = new CellContent[height][width];

        Arrays.stream(cellContents).forEach(y -> Arrays.stream(y).forEach(x -> x = empty));
    }

    private CellContent getCellContentByPos(Position pos) {

        Modulate(pos);

        return cellContents[pos.getX()][pos.getY()];
    }

    private void Modulate(Position pos) {

        pos.setX(pos.getX() % getWidth());
    }

    @Override
    public CellContent getCellContent(Position pos) {

        return getCellContentByPos(pos);
    }

    @Override
    public void setCellContent(Position pos, CellContent newCellContent) {

        var cellContent = getCellContentByPos(pos);
        cellContent = newCellContent;
    }

    @Override
    public void setEmpty(Position pos) {

        var cellContent = getCellContentByPos(pos);
        cellContent = empty;
    }

    @Override
    public boolean isEmpty(Position pos) {

        return getCellContentByPos(pos).equals(empty);
    }

    @Override
    public boolean isInBounds(Position pos) {

        Modulate(pos);

        return pos.getY() >= 0 && pos.getY() < getHeight();
    }

    @Override
    public int getWidth() {

        return cellContents[0].length;
    }

    @Override
    public int getHeight() {

        return cellContents.length;
    }
}
