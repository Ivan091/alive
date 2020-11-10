package alive.field;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.BotGenome;
import alive.bot.genome.gene.Gene;
import alive.bot.model.*;
import alive.bot.position.BotPosition;
import alive.field.cell.*;

import java.util.*;

public class MainField implements Field {

    private final Cells cells;

    private final List<Alive> aliveBots;

    private final Queue<Alive> newAliveBots;

    public MainField(int height, int width) {

        cells = new FieldCells(height, width);
        aliveBots = new LinkedList<>();
        newAliveBots = new ArrayDeque<>() {
        };
    }

    public void start() {

        var firstBot = new AliveBot(this, new BotPosition(1, 1), 500,
                new BotLookDirection(), new BotGenome());

        addNewAlive(firstBot);

        for (var i = 0; i < 1000000000; ++i) {

            update();

            if (i % 100000 == 0) {
                createGenesReport();
                System.out.println('\n');
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

        map.forEach((x, y) -> System.out.format("%-5s%s", y.toString(), x.getSimpleName() + '\n'));
    }

    @Override
    public int getWidth() {

        return cells.getWidth();
    }

    @Override
    public int getHeight() {

        return cells.getHeight();
    }

    @Override
    public Cells getCells() {

        return cells;
    }

    @Override
    public void addNewAlive(Alive newAlive) {

        try {
            cells.setCellContent(newAlive.getPosition(), newAlive);
            newAliveBots.add(newAlive);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
