package alive.field;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.BotGenome;
import alive.bot.model.Alive;
import alive.bot.model.AliveBot;
import alive.bot.position.BotPosition;
import alive.field.cell.Cells;
import alive.field.cell.FieldCells;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainField implements Field {

    private final Cells cells;

    private final List<Alive> aliveBots;

    private final Queue<Alive> newAliveBots;

    public MainField(int height, int width) {

        cells = new FieldCells(height, width);
        aliveBots = new LinkedList<>();
        newAliveBots = new LinkedList<>();
    }

    public void start() {

        var firstBot = new AliveBot(this, new BotPosition(1, 1), 500,
                new BotLookDirection(), new BotGenome());

        addNewAlive(firstBot);

        for (var i = 0; i < 1000000000; ++i) {
            
            update();

            if (aliveBots.size() == 0) {

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
