package alive.entities.alive.bot.energy;

import alive.WorldConstants;
import alive.entities.alive.Mortal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EnergyAliveAliveTest {

    Mortal mortalMock = mock(Mortal.class);
    EnergyAlive energy = new EnergyAliveAlive(500);

    @BeforeEach
    public void subscribe() {
        energy.subscribeMortal(mortalMock);
    }

    @Test
    void getAndSetEnergyValue() {

        energy.setEnergyValue(600);

        assertEquals(600, energy.getEnergyValue());

        energy.setEnergyValue(0);

        assertEquals(0, energy.getEnergyValue());
    }

    @Test
    void isAliveReplicated() {

        energy.setEnergyValue(WorldConstants.MAX_ENERGY_VALUE + 1);
        energy.incrementEnergyValue(0);

        Mockito.verify(mortalMock, times(1)).replicate();
    }

    @Test
    void isAliveDestroyed() {

        energy.setEnergyValue(WorldConstants.MIN_ENERGY_VALUE - 1);
        energy.incrementEnergyValue(0);

        verify(mortalMock, times(1)).destroy();
    }

    @Test
    void incrementEnergyValue() {

        energy.setEnergyValue(0);

        assertEquals(0, energy.getEnergyValue());

        energy.incrementEnergyValue(1000);

        assertEquals(1000, energy.getEnergyValue());

        energy.incrementEnergyValue(-999);

        assertEquals(1, energy.getEnergyValue());
    }
}