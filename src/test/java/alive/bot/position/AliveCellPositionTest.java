package alive.bot.position;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AliveCellPositionTest {

    private final Position pos = new BotPosition(3, 3);

    @Test
    void getPositionsAround() {


    }

    @Test
    void getX() {

        assertEquals(3, pos.getX());
    }

    @Test
    void getY() {

        assertEquals(3, pos.getY());
    }

    @Test
    void testHashCodeThenEquals() {

        var positions = Stream.of(
                new BotPosition(1, 1),
                new BotPosition(1, 1),
                new BotPosition(1, 2),
                new BotPosition(2, 1),
                new BotPosition(2, 1),
                new BotPosition(-1, 1),
                new BotPosition(-2, 1),
                new BotPosition(-2, 1),
                new BotPosition(-1, -1),
                new BotPosition(1, -1)
        ).collect(Collectors.toCollection(HashSet::new));

        assertEquals(7, positions.size());
    }
}