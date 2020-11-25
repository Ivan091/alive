package alive.bot.condition;

public class BotLiveCondition implements LiveCondition {

    private LiveConditions liveCondition;

    public BotLiveCondition(LiveConditions liveCondition) {

        this.liveCondition = liveCondition;
    }

    public BotLiveCondition() {

        liveCondition = LiveConditions.ALIVE;
    }

    @Override
    public void makeDead() {

        liveCondition = LiveConditions.DEAD;
    }

    @Override
    public boolean isAlive() {

        return liveCondition == LiveConditions.ALIVE;
    }
}
