package alive.bot.condition;

import alive.bot.condition.live.alive.BotAliveCondition;
import alive.bot.condition.live.dead.BotDeadCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BotConditionTest {

    @Test
    void isAlive() {

        var condition = new BotCondition(new BotAliveCondition());

        Assertions.assertTrue(condition.isAlive());

        condition.setLiveCondition(new BotDeadCondition());

        Assertions.assertFalse(condition.isAlive());
    }
}