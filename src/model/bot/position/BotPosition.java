package model.bot.position;

import model.Field;

import java.util.ArrayList;
import java.util.List;

public class BotPosition {

    public final int x;
    public final int y;

    public BotPosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * @param field main field
     * @return list of positions around the bot
     */
    public List<BotPosition> getPositionsAround(Field field) {

        var positionsAround = new ArrayList<BotPosition>(8);

        for (var i = x - 1; i <= x + 1; ++i) {
            for (var j = y - 1; j <= y + 1; ++j) {
                if (y > 0 && y < field.width) {
                    if (i != x || j != y) {
                        var newPosition = new BotPosition((i + field.width) % field.width, j);
                        positionsAround.add(newPosition);
                    }
                }
            }
        }

        return positionsAround;
    }
}
