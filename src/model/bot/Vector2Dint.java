package model.bot;

import model.Field;

import java.util.ArrayList;

public class Vector2Dint {

    private final int x;
    private final int y;

    public Vector2Dint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param field main field
     * @return list of coordinates around the bot
     */
    public ArrayList<Vector2Dint> getCellsVectorsNearBy(Field field) {

        var vectorList = new ArrayList<Vector2Dint>(8);

        for (var i = x - 1; i <= x + 1; ++i) {
            for (var j = y - 1; j <= y + 1; ++j) {
                if (y > 0 && y < field.weight) {
                    if (i != x || j != y) {
                        var newVector = new Vector2Dint((i + field.weight) % field.weight, j);
                        vectorList.add(newVector);
                    }
                }
            }
        }

        return vectorList;
    }
}
