package alive.field;

import alive.bot.direction.look.BotLookDirection;
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

    public MainField(int height, int width) {

        cells = new FieldCells(height, width);
        aliveBots = new LinkedList<>();
    }

    public void start() {

        var firstBot = new AliveBot(this, new BotPosition(1, 2), 500,
                new BotLookDirection());

        aliveBots.add(firstBot);

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
}
