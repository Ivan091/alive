package alive.bot.condition;

import alive.bot.condition.live.LiveCondition;

public interface Condition {

    LiveCondition getLiveCondition();

    void setLiveCondition(LiveCondition liveCondition);

    boolean isAlive();
}
