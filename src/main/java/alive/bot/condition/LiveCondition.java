package alive.bot.condition;

public interface LiveCondition {

    /**
     * @return <b>true</b> if bot is alive, <b>false</b> if dead.
     */
    boolean isAlive();

    void makeDead();
}
