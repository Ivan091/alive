package com.Model;

import com.Model.Bot.Bot;
import com.Model.Bot.IBot;

import java.util.ArrayList;

public class Field {

    public final int height;

    public final int weight;

    private final ArrayList<IBot> bots;

    public Field(int height , int weight ) {
        this.height = height;
        this.weight = weight;
        bots = new ArrayList<>(height * weight);
    }

    public void Start() {
        var firstBot = new Bot(height / 2, weight / 2, this, 500);
        bots.add(firstBot);

        while (true) {
            Update();
        }
    }

    private void Update() {
        for (var bot : bots) {
            bot.makeAMove();
        }
    }
}
