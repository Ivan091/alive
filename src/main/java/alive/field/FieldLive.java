package alive.field;

import alive.entities.Entity;
import alive.field.cells.CellMatrix;
import alive.field.cells.CellMatrixLive;

import java.util.*;

public class FieldLive implements Field {

    private final CellMatrix cellMatrix;

    private final List<Entity> aliveEntities;

    private final Queue<Entity> entitiesPutThisTurn;

    public FieldLive(int width, int height) {

        cellMatrix = new CellMatrixLive(height, width);
        aliveEntities = new LinkedList<>();
        entitiesPutThisTurn = new ArrayDeque<>();
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
        entitiesPutThisTurn.add(puttingEntity);
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

        while (!entitiesPutThisTurn.isEmpty()) {
            var curBot = entitiesPutThisTurn.poll();

            if (curBot.isAlive()) {
                curBot.makeAMove();
                aliveEntities.add(curBot);
            }
        }
    }

    @Override
    public int aliveEntitiesCount() {
        return aliveEntities.size() + entitiesPutThisTurn.size();
    }
}
