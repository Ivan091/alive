package Model.Bot.Command;

import Model.Bot.Bot;
import Model.Field;

public interface ICommand {
    /**
     * Runs current command
     * @param bot current bot
     * @param field main field
     * @return how much the bot's index will be moved
     */
    int run(Bot bot, Field field);

    /**
     * If bots differ in one command only they will be friendly
     * @param obj another command
     * @return result of commands comparison
     */
    boolean equals(Object obj);
}
