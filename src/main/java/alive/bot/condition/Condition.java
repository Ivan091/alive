package alive.bot.condition;

import alive.bot.condition.live.LiveConditions;

public interface Condition {

    /**
     *
     * @return <b>true</b> if bot is alive, <b>false</b> if dead.
     */
    boolean isAlive();

    LiveConditions getLiveCondition();

    void setLiveCondition(LiveConditions liveCondition);
}
