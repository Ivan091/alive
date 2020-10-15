package model;


import model.bot.Bot;
import model.bot.Movable;

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

        var firstBot = new Bot(height / 2, width / 2, 500);
        bots.add(firstBot);

        for (var i = 0; i < 100; ++i) {
            update();
        }
    }

    private void update() {

        bots.forEach(bot -> bot.makeAMove(this));
    }
}
