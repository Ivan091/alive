package alive.field;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.BotGenome;
import alive.bot.genome.gene.Gene;
import alive.bot.model.*;
import alive.bot.position.BotPosition;
import alive.field.cells.CellsMatrix;
import alive.field.cells.FieldCellsMatrix;

import java.util.*;

public class MainField implements Field {

    private final CellsMatrix cellsMatrix;

    private final List<Alive> aliveBots;

    private final Queue<Alive> newAliveBots;

    public MainField(int height, int width) {

        cellsMatrix = new FieldCellsMatrix(height, width);
        aliveBots = new LinkedList<>();
        newAliveBots = new ArrayDeque<>() {
        };
    }

    public void start() {

        var firstBot = new AliveBot(this, new BotPosition(1, 1), 500,
                new BotLookDirection(), new BotGenome());

        addNewAlive(firstBot);

        for (var i = 0; ; ++i) {

            update();

            if (i % 100000 == 0) {
                System.out.println('\n');
                createGenesReport();
                System.out.println('\n');
            }
            if (i % 1000 == 0) {
                System.out.print(aliveBots.size() + " ");
            }

            if (aliveBots.size() == 0) {

                System.out.println("\nThe population is dead(((");
                return;
            }
        }
    }

    private void update() {

        var botsIt = aliveBots.iterator();

        while (botsIt.hasNext()) {

            var curBot = botsIt.next();

            curBot.makeAMove();

            if (!curBot.isAlive()) {
                botsIt.remove();
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

    @Override
    public int getWidth() {

        return cellsMatrix.getWidth();
    }

    @Override
    public int getHeight() {

        return cellsMatrix.getHeight();
    }

    @Override
    public CellsMatrix getCells() {

        return cellsMatrix;
    }

    @Override
    public void addNewAlive(Alive newAlive) {

        cellsMatrix.setContent(newAlive.getPosition(), newAlive);
        newAliveBots.add(newAlive);
    }
}
