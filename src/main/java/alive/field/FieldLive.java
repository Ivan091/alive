package alive.field;

import alive.entities.Entity;
import alive.field.cells.CellMatrix;
import alive.field.cells.CellMatrixLive;

import java.util.*;

public class FieldLive implements Field {

    private final CellMatrix cellMatrix;

    private final List<Entity> aliveEntities;

    private final Queue<Entity> aliveEntitiesPutThisTurn;

    public FieldLive(int height, int width) {

        cellMatrix = new CellMatrixLive(height, width);
        aliveEntities = new LinkedList<>();
        aliveEntitiesPutThisTurn = new ArrayDeque<>();
    }

    @Override
    public int getWidth() {

        return cellMatrix.getWidth();
    }

    @Override
    public int getHeight() {

        return cellMatrix.getHeight();
    }

    @Override
    public CellMatrix getCellsMatrix() {

        return cellMatrix;
    }

    @Override
    public void putEntity(Entity puttingEntity) {

        cellMatrix.putEntity(puttingEntity);
        aliveEntitiesPutThisTurn.add(puttingEntity);
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
}
