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

public class MainField implements Field {

    private final Cells cells;

    private final List<Alive> aliveBots;

    private final List<Alive> newAliveBots;

    public MainField(int height, int width) {

        cells = new FieldCells(height, width);
        aliveBots = new LinkedList<>();
        newAliveBots = new LinkedList<>();
    }

    public void start() {

        var firstBot = new AliveBot(this, new BotPosition(1, 1), 500,
                new BotLookDirection(), new BotGenome());

        addNewAlive(firstBot);

        for (var i = 0; i < 100; ++i) {
            update();
        }
    }

    private void update() {

        var botsIt = aliveBots.listIterator();

        while (botsIt.hasNext()) {

            var curBot = botsIt.next();

            curBot.makeAMove();

            if (!curBot.isAlive()) {
                botsIt.remove();
            }
        }

        var newBotsIt = newAliveBots.listIterator();

        while (botsIt.hasNext()) {

            var curBot = botsIt.next();

            curBot.makeAMove();

            if (!curBot.isAlive()) {
                botsIt.remove();
            }
        }

        aliveBots.addAll(newAliveBots);
        newAliveBots.clear();
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

        if (cells.trySetCellContent(newAlive.getPosition(), newAlive)) {
            newAliveBots.add(newAlive);
        }
    }
}
