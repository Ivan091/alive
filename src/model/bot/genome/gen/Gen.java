package model.bot.genome.gen;

import model.Field;
import model.bot.Bot;

public interface Gen {

    /**
     * Runs current gen.
     *
     * @param bot   current bot
     * @param field main field
     * @return if the command ends the turn returns <b>true</b>
     * else returns <b>false</b>
     */
    boolean run(Bot bot, Field field);

    /**
     * If bots differ in one gen only they will be friendly
     *
     * @param obj another gen
     * @return result of genes comparison
     */
    boolean equals(Object obj);
}
