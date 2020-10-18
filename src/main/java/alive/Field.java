package alive;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.model.Bot;
import alive.bot.model.Movable;
import alive.bot.position.BotPosition;

import java.util.ArrayList;
import java.util.List;


public class Field {

    public final int height;

    public final int width;

    private final List<Movable> bots;

    public Field(int height, int width) {

        this.height = height;
        this.width = width;
        bots = new ArrayList<>(height * width);
    }

    public void start() {

        var firstBot = new Bot(new BotPosition(width / 2, height / 2), 500,
                new BotLookDirection(1, 0));

        bots.add(firstBot);

        for (var i = 0; i < 100; ++i) {
            update();
        }
    }

    private void update() {

        bots.forEach(bot -> bot.makeAMove(this));
    }
}
