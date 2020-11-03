package alive.bot.direction.look;

import alive.bot.position.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotLookDirectionTest {

    private final Position startPos = new BotPosition(0, 0);
    private final LookDirection lookDir = new BotLookDirection(0);

    @Test
    void rotate() {

        lookDir.rotate(4);
        lookDir.rotate(4);
        assertEquals(new BotPosition(1, 1), lookDir.getLookingPos(startPos));

        lookDir.rotate(-8);
        assertEquals(new BotPosition(1, 1), lookDir.getLookingPos(startPos));

        lookDir.rotate(1);
        assertEquals(new BotPosition(0, 1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new BotPosition(-1, 1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new BotPosition(-1, 0), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new BotPosition(-1, -1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new BotPosition(0, -1), lookDir.getLookingPos(startPos));


        lookDir.rotate(-7);
        assertEquals(new BotPosition(1, -1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new BotPosition(1, 0), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new BotPosition(1, 1), lookDir.getLookingPos(startPos));
    }

    @Test
    void getOpposite() {

        var opposite = lookDir.getOpposite().getLookingPos(startPos);
        lookDir.rotate(4);
        var opposite2 = lookDir.getLookingPos(startPos);

        assertEquals(opposite, opposite2);
    }

    @Test
    void replicate() {

        var replicated = lookDir.replicate();

        assertEquals(lookDir.getLookingPos(startPos), replicated.getLookingPos(startPos));
    }
}