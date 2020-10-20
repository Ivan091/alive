package alive.bot.condition;

import alive.bot.condition.live.LiveCondition;
import alive.bot.condition.live.alive.AliveCondition;

public class BotCondition implements Condition {

    private LiveCondition liveCondition;

    public BotCondition(LiveCondition liveCondition) {

        this.liveCondition = liveCondition;
    }

    @Override
    public LiveCondition getLiveCondition() {

        return liveCondition;
    }

    @Override
    public void setLiveCondition(LiveCondition liveCondition) {

        this.liveCondition = liveCondition;
    }

    @Override
    public boolean isAlive() {

        return liveCondition instanceof AliveCondition;
    }
}
