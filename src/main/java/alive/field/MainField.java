package alive.field;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.BotGenome;
import alive.bot.genome.gene.Gene;
import alive.bot.model.*;
import alive.bot.position.EntityPosition;
import alive.field.cells.CellsMatrix;
import alive.field.cells.FieldCellsMatrix;
import alive.field.cells.content.Entity;

import java.util.*;

public class MainField implements Field {

    private final CellsMatrix cellsMatrix;

    private final List<Alive> aliveBots;

    private final Queue<Alive> newAliveBots;

    public MainField(int height, int width) {

        cellsMatrix = new FieldCellsMatrix(height, width);
        aliveBots = new LinkedList<>();
        newAliveBots = new ArrayDeque<>();
    }

    public void start() {

        addNewAlive(new AliveBot(this, new EntityPosition(0, 0), 500, new BotLookDirection(), BotGenome.createFirstBotGenome()));

        for (var i = 0; i < Integer.MAX_VALUE; ++i) {

            update();

            if (i % 100000 == 0) {
                System.out.println('\n');
                createGenesReport();
                System.out.println('\n');
                createFieldReport();
                System.out.println('\n');
            }

            if (aliveBots.size() == 0) {

                System.out.println("\nThe population is dead(((");
                return;
            }
        }
    }

    private void update() {

        var aliveBotsIt = aliveBots.iterator();
        while (aliveBotsIt.hasNext()) {

            var curBot = aliveBotsIt.next();

            curBot.makeAMove();

            if (!curBot.isAlive()) {
                aliveBotsIt.remove();
            }
        }

        while (!newAliveBots.isEmpty()) {
            var curBot = newAliveBots.poll();

            if (curBot.isAlive()) {
                curBot.makeAMove();
                aliveBots.add(curBot);
            }
        }
    }

    private void createGenesReport() {

        var map = new HashMap<Class<? extends Gene>, Integer>();

        try {
            for (var alive : aliveBots) {
                var bot = (Bot) alive;
                var genome = bot.getGenome();

                var f = genome.getClass().getDeclaredField("genes");
                f.setAccessible(true);

                var genes = (Gene[]) f.get(genome);

                for (var gene : genes) {
                    map.merge(gene.getClass(), 1, Integer::sum);
                }
            }
        } catch (Exception ignored) {
        }

        map.forEach((x, y) -> System.out.format("%-9s%s", y.toString(), x.getSimpleName() + '\n'));
    }

    private void createFieldReport() {
        var map = new HashMap<Class<? extends Entity>, Integer>();
        for (var i = 0; i < getHeight(); ++i) {
            for (var j = 0; j < getWidth(); ++j) {
                var pos = new EntityPosition(i, j);
                map.merge(cellsMatrix.getEntity(pos).getClass(), 1, Integer::sum);
            }
        }

        map.forEach((x, y) -> System.out.format("%-9s%s", y.toString(), x.getSimpleName() + '\n'));
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
    public void addNewAlive(Alive newAlive) {

        cellsMatrix.addEntity(newAlive);
        newAliveBots.add(newAlive);
    }
}
