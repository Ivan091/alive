package alive.organic.cell;

import alive.organic.health.Health;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CellHealthTest {

    Health health = new Health(100);

    @Test
    void givesActualHealth() {
        assertEquals(100, health.health());
    }

    @Test
    void doublesHealth() {
        health.heal(x -> x * 2);
        assertEquals(200, health.health());
    }

    @Test
    void incrementsHealth() {
        health.heal(x -> x + 1);
        assertEquals(101, health.health());
    }

    @Test
    void decrementsHealth() {
        health.heal(x -> x - 1);
        assertEquals(99, health.health());
    }

    @Test
    void dividesHealth() {
        health.heal(x -> x / 2);
        assertEquals(50, health.health());
    }
}