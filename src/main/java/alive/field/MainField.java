package alive.field;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.model.Alive;
import alive.bot.model.AliveBot;
import alive.bot.position.BotPosition;
import alive.field.cell.content.CellContent;
import alive.field.cell.content.Empty;

import java.util.LinkedList;
import java.util.List;

public class MainField implements Field {

    private final int height;

    private final int width;

    private final CellContent[][] cells;

    private final List<Alive> aliveBots;

    private static final CellContent emptyCell = new Empty();

    public MainField(int height, int width) {

        this.height = height;
        this.width = width;

        aliveBots = new LinkedList<>();

        cells = new CellContent[height][width];

        for (var i = 0; i < height; ++i) {
            for (var j = 0; j < width; ++j) {
                cells[i][j] = emptyCell;
            }
        }
    }

    public void start() {

        var firstBot = new AliveBot(new BotPosition(width / 2, height / 2), 500,
                new BotLookDirection(1, 0));

        aliveBots.add(firstBot);

        for (var i = 0; i < 100; ++i) {
            update();
        }
    }

    private void update() {

        var botsIt = aliveBots.listIterator();

        while (botsIt.hasNext()) {

            var currentBot = botsIt.next();

            currentBot.makeAMove(this);

            if (!currentBot.getLiveCondition().isAlive()) {
                botsIt.remove();
            }
        }
    }

    @Override
    public int getHeight() {

        return height;
    }

    @Override
    public int getWidth() {

        return width;
    }
}
