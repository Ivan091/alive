package alive.bot.condition;

import alive.bot.condition.live.LiveConditions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotConditionTest {

    BotCondition botCondition = new BotCondition(LiveConditions.DEAD);

    @Test
    void getLiveCondition() {

        assertEquals(LiveConditions.DEAD, botCondition.getLiveCondition());
    }

    @Test
    void setLiveCondition() {


        botCondition.setLiveCondition(LiveConditions.ALIVE);
        assertEquals(LiveConditions.ALIVE, botCondition.getLiveCondition());

        botCondition.setLiveCondition(LiveConditions.DEAD);
        assertEquals(LiveConditions.DEAD, botCondition.getLiveCondition());
    }

    @Test
    void isAlive() {

        botCondition.setLiveCondition(LiveConditions.ALIVE);
        assertTrue(botCondition.isAlive());

        botCondition.setLiveCondition(LiveConditions.DEAD);
        assertFalse(botCondition.isAlive());
    }
}