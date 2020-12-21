package alive.entities.lifeless;

import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmptyEntityTest {

    @Test
    void testEquals() {

        var empty1 = new EmptyEntity(new PositionEntity(0, 0), new EnergyEntity(0));
        var empty2 = new EmptyEntity(new PositionEntity(0, 0), new EnergyEntity(0));

        assertEquals(empty1, empty2);

        empty2 = new EmptyEntity(new PositionEntity(1, 2), new EnergyEntity(100));

        assertEquals(empty1, empty2);

        Assertions.assertNotEquals(empty1, null);
    }
}