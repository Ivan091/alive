package alive.bot.model;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.position.BotPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AliveBotTest {

    @Test
    void destroy() {

        var bot = new AliveBot(new BotPosition(1, 1), 1, new BotLookDirection());

        assertTrue(bot.isAlive());

        bot.Destroy();

        assertFalse(bot.isAlive());
    }
}