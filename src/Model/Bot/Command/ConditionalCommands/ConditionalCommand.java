package Model.Bot.Command.ConditionalCommands;

import Model.Bot.Command.ICommand;

public abstract class ConditionalCommand implements ICommand {

    /**
     * parameter for conditional jump
     */
    protected int key;

    /**
     * @param key Using as a parameter for conditional jump.
     *
     */
    public ConditionalCommand(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass() == this.getClass()) && ((ConditionalCommand)obj).key == this.key;
    }
}
