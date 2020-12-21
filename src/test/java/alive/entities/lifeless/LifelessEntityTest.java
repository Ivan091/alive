package alive.entities.lifeless;

import alive.entities.qualities.energy.Energy;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LifelessEntityTest {

    Energy energy = new EnergyEntity(200);
    LifelessEntity body = spy(new LifelessBotBody(mock(Position.class), energy));

    @Test
    void isAlive() {
        Assertions.assertFalse(body.isAlive());
    }

    @Test
    void getEnergy() {
        Assertions.assertEquals(energy, body.getEnergy());
    }

    @Test
    void makeAMove() {
        Assertions.assertDoesNotThrow(() -> body.makeAMove());
    }
}