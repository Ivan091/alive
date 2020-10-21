package alive.bot.direction.look;

import alive.bot.position.BotPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BotLookDirectionTest {

    @Test
    void rotateAndGetLookingPos() {

        var dir = new BotLookDirection(1);
        var curPos = new BotPosition(0, 0);

        Assertions.assertEquals(dir.getLookingPos(curPos), new BotPosition(0, 1));

        dir.rotate(1);
        Assertions.assertEquals(dir.getLookingPos(curPos), new BotPosition(-1, 1));

        dir.rotate(-1);
        Assertions.assertEquals(dir.getLookingPos(curPos), new BotPosition(0, 1));

        dir.rotate(4);
        Assertions.assertEquals(dir.getLookingPos(curPos), new BotPosition(0, -1));

        dir.rotate(16);
        Assertions.assertEquals(dir.getLookingPos(curPos), new BotPosition(0, -1));

        dir.rotate(2);
        Assertions.assertEquals(dir.getLookingPos(curPos), new BotPosition(1, 0));
    }

    @Test
    void getLookingPos() {

        var pos = new BotPosition(0, 0);
        Assertions.assertEquals(new BotLookDirection(0).getLookingPos(pos), new BotPosition(1, 1));
        Assertions.assertEquals(new BotLookDirection(1).getLookingPos(pos), new BotPosition(0, 1));
        Assertions.assertEquals(new BotLookDirection(2).getLookingPos(pos), new BotPosition(-1, 1));
        Assertions.assertEquals(new BotLookDirection(3).getLookingPos(pos), new BotPosition(-1, 0));
        Assertions.assertEquals(new BotLookDirection(4).getLookingPos(pos), new BotPosition(-1, -1));
        Assertions.assertEquals(new BotLookDirection(5).getLookingPos(pos), new BotPosition(0, -1));
        Assertions.assertEquals(new BotLookDirection(6).getLookingPos(pos), new BotPosition(1, -1));
        Assertions.assertEquals(new BotLookDirection(7).getLookingPos(pos), new BotPosition(1, 0));
    }
}