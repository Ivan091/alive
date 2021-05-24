package alive.alive.cell;

import alive.alive.health.HealthBasic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CellHealthBasicTest {

    HealthBasic healthBasic = new HealthBasic(100);

    @Test
    void givesActualHealth() {
        assertEquals(100, healthBasic.health());
    }

    @Test
    void doublesHealth() {
        healthBasic.heal(x -> x * 2);
        assertEquals(200, healthBasic.health());
    }

    @Test
    void incrementsHealth() {
        healthBasic.heal(x -> x + 1);
        assertEquals(101, healthBasic.health());
    }

    @Test
    void decrementsHealth() {
        healthBasic.heal(x -> x - 1);
        assertEquals(99, healthBasic.health());
    }

    @Test
    void dividesHealth() {
        healthBasic.heal(x -> x / 2);
        assertEquals(50, healthBasic.health());
    }
}