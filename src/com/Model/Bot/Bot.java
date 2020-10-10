package com.Model.Bot;

import com.Model.Bot.Command.DirectCommands.Photosynthesis;
import com.Model.Bot.Command.ICommand;
import com.Model.Field;

public class Bot implements IBot {

    public final Vector2Dint coordinates;

    public int energy;

    private final Field field;

    private int index;

    private final ICommand[] commands;

    public Bot(int x, int y, Field field, int energy) {
        coordinates = new Vector2Dint(x, y);
        this.field = field;
        this.energy = energy;

        /**
         * At the start each bot has photosynthesis commands only.
         */
        commands = new ICommand[64];
        for (var i = 0; i < commands.length; ++i) {
            commands[i] = new Photosynthesis();
        }
    }

    @Override
    public void makeAMove() {

        index = (index + commands[index].run(this, field)) % commands.length;
        energy -= 4;
    }

}
