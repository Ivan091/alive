package alive.bot.condition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotLiveConditionTest {

    BotLiveCondition botCondition = new BotLiveCondition();

    @Test
    void isAlive() {

        assertTrue(botCondition.isAlive());
        botCondition.makeDead();
        assertFalse(botCondition.isAlive());
    }
}