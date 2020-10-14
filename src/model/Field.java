package model;


import model.bot.Bot;
import model.bot.IBotMakeAMove;

import java.util.ArrayList;

public class Field {

    public final int height;

    public final int weight;

    private final ArrayList<IBotMakeAMove> bots;

    public Field(int height , int weight ) {
        this.height = height;
        this.weight = weight;
        bots = new ArrayList<>(height * weight);
    }

    public void Start() {
        var first = new Bot(height / 2, weight / 2, 500);
        bots.add(first);

        for (var i = 0; i < 10; ++i) {
            Update();
        }
    }

    private void Update() {
        for (var bot : bots) {
            bot.makeAMove(this);
        }
    }
}
