package alive.entities.alive.bot.energy;

import alive.WorldConstants;
import alive.entities.alive.Mortal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AliveBotEnergyTest {

    Mortal alive = mock(Mortal.class);
    AliveBotEnergy energy = new AliveBotEnergy(alive, 500);

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

        Mockito.verify(alive, times(1)).replicate();
    }

    @Test
    void isAliveDestroyed() {

        energy.setEnergyValue(WorldConstants.MIN_ENERGY_VALUE - 1);
        energy.incrementEnergyValue(0);

        verify(alive, times(1)).destroy();
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