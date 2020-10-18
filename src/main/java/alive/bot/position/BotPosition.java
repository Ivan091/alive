package alive.bot.position;

import alive.Field;

import java.util.ArrayList;
import java.util.List;

public class BotPosition implements Position {

    private int x;
    private int y;

    public BotPosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {

        return x;
    }

    @Override
    public int getY() {

        return y;
    }

    /**
     * @param field main field
     * @return list of positions around the alive.bot
     */
    @Override
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
