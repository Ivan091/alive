package alive.bot.condition;

import alive.bot.condition.live.LiveConditions;

public interface Condition {

    LiveConditions getLiveCondition();

    void setLiveCondition(LiveConditions liveCondition);

    boolean isAlive();
}
