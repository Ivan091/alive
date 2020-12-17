package alive.entities.alive.bot.direction.look;

import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.qualities.direction.LookDirection;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BotLookDirectionTest {

    private final Position startPos = new PositionEntity(0, 0);
    private final LookDirection lookDir = new BotLookDirection(1);

    @Test
    void rotate() {

        lookDir.rotate(4);
        lookDir.rotate(4);
        assertEquals(new PositionEntity(1, 1), lookDir.getLookingPos(startPos));

        lookDir.rotate(-8);
        assertEquals(new PositionEntity(1, 1), lookDir.getLookingPos(startPos));

        lookDir.rotate(1);
        assertEquals(new PositionEntity(0, 1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new PositionEntity(-1, 1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new PositionEntity(-1, 0), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new PositionEntity(-1, -1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new PositionEntity(0, -1), lookDir.getLookingPos(startPos));


        lookDir.rotate(-7);
        assertEquals(new PositionEntity(1, -1), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new PositionEntity(1, 0), lookDir.getLookingPos(startPos));


        lookDir.rotate(1);
        assertEquals(new PositionEntity(1, 1), lookDir.getLookingPos(startPos));
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