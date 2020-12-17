package alive.field;

import alive.entities.Entity;
import alive.field.cells.CellsMatrix;
import alive.field.cells.FieldCellsMatrix;

import java.util.*;

public class MainField implements Field {

    private final CellsMatrix cellsMatrix;

    private final List<Entity> aliveEntities;

    private final Queue<Entity> aliveEntitiesPutThisTurn;

    public MainField(int height, int width) {

        cellsMatrix = new FieldCellsMatrix(height, width);
        aliveEntities = new LinkedList<>();
        aliveEntitiesPutThisTurn = new ArrayDeque<>();
    }

    @Override
    public void update() {

        var aliveBotsIt = aliveEntities.iterator();
        while (aliveBotsIt.hasNext()) {

            var curBot = aliveBotsIt.next();

            curBot.makeAMove();

            if (!curBot.isAlive()) {
                aliveBotsIt.remove();
            }
        }

        while (!aliveEntitiesPutThisTurn.isEmpty()) {
            var curBot = aliveEntitiesPutThisTurn.poll();

            if (curBot.isAlive()) {
                curBot.makeAMove();
                aliveEntities.add(curBot);
            }
        }
    }

    @Override
    public int aliveCount() {
        return aliveEntities.size() + aliveEntitiesPutThisTurn.size();
    }

    @Override
    public int getWidth() {

        return cellsMatrix.getWidth();
    }

    @Override
    public int getHeight() {

        return cellsMatrix.getHeight();
    }

    @Override
    public CellsMatrix getCellsMatrix() {

        return cellsMatrix;
    }

    @Override
    public void putEntity(Entity puttingEntity) {

        cellsMatrix.addEntity(puttingEntity);
        aliveEntitiesPutThisTurn.add(puttingEntity);
    }
}
