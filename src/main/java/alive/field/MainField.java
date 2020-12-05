package alive.field;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.BotGenome;
import alive.bot.genome.gene.Gene;
import alive.bot.model.*;
import alive.bot.position.BotPosition;
import alive.field.cells.CellsMatrix;
import alive.field.cells.FieldCellsMatrix;
import alive.field.cells.content.Content;

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

        addNewAlive(new AliveBot(this, new BotPosition(0, 0), 500, new BotLookDirection(), BotGenome.createFirstBotGenome()));

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
                //return;
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
            curBot.makeAMove();

            if (curBot.isAlive()) {
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
        var map = new HashMap<Class<? extends Content>, Integer>();
        var pos = new BotPosition(0, 0);
        for (var i = 0; i < getHeight(); pos.setX(i), ++i) {
            for (var j = 0; j < getWidth(); pos.setY(j), ++j) {
                map.merge(cellsMatrix.getContent(pos).getClass(), 1, Integer::sum);
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

        cellsMatrix.setContent(newAlive.getPosition(), newAlive);
        newAliveBots.add(newAlive);
    }
}
