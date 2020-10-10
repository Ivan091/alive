package com.Model.Bot.Command;

import com.Model.Bot.Bot;
import com.Model.Field;

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
