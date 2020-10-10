package com.Model.Bot.Command.DirectCommands;

import com.Model.Bot.Command.ICommand;

public abstract class DirectCommand implements ICommand {

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}
