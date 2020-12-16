package alive.bot.position;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityPositionTest {

    private final Position pos = new EntityPosition(3, 3);

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
                new EntityPosition(1, 1),
                new EntityPosition(1, 1),
                new EntityPosition(1, 2),
                new EntityPosition(2, 1),
                new EntityPosition(2, 1),
                new EntityPosition(-1, 1),
                new EntityPosition(-2, 1),
                new EntityPosition(-2, 1),
                new EntityPosition(-1, -1),
                new EntityPosition(1, -1)
        ).collect(Collectors.toCollection(HashSet::new));

        assertEquals(7, positions.size());
    }
}