package Model.Bot.Command.DirectCommands;

import Model.Bot.Command.ICommand;

public abstract class DirectCommand implements ICommand {

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}
