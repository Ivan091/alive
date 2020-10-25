package alive.bot.genome.gene;

import alive.bot.genome.Replicable;
import alive.bot.model.Bot;

public interface Gene extends Replicable<Gene> {

    /**
     * Runs current gen.
     *
     * @param bot current bot
     * @return if the command ends the turn returns <b>true</b>
     * else returns <b>false</b>
     */
    boolean run(Bot bot);

    /**
     * If bots differ in one gen only they will be friendly.
     *
     * @param obj another gen
     * @return result of genes comparison
     */
    boolean equals(Object obj);
}
