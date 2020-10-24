package alive.bot.condition;

import alive.bot.condition.live.LiveConditions;

public class BotCondition implements Condition {

    private LiveConditions liveCondition;

    public BotCondition(LiveConditions liveCondition) {

        this.liveCondition = liveCondition;
    }

    @Override
    public LiveConditions getLiveCondition() {

        return liveCondition;
    }

    @Override
    public void setLiveCondition(LiveConditions liveCondition) {

        this.liveCondition = liveCondition;
    }

    @Override
    public boolean isAlive() {

        return liveCondition == LiveConditions.ALIVE;
    }
}
