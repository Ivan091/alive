package com.domain.simulation.entities.alive.bot.single.energy;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.Mortal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EnergyAliveMortalTest {

    Mortal mortalMock = mock(Mortal.class);
    EnergyMortal energy = new EnergyAliveMortal(500);

    @BeforeEach
    public void subscribe() {
        energy.subscribeMortal(mortalMock);
    }

    @Test
    void getAndSetEnergyValue() {

        energy.changeValue(v -> 600d);

        assertEquals(600, energy.value());

        energy.changeValue(v -> 0d);

        assertEquals(0, energy.value());
    }

    @Test
    void isAliveReplicated() {

        energy.changeValue(v -> v + WorldConstants.MAX_ENERGY_VALUE + 1);
        energy.changeValue(v -> 0d);

        Mockito.verify(mortalMock, times(1)).replicate();
    }

    @Test
    void isAliveDestroyed() {

        energy.changeValue(v -> v + WorldConstants.MIN_ENERGY_VALUE - 1);
        energy.changeValue(v -> 0d);

        verify(mortalMock, times(1)).destroy();
    }

    @Test
    void incrementEnergyValue() {

        energy.changeValue(v -> 0d);

        assertEquals(0, energy.value());

        energy.changeValue(v -> v + 1000);

        assertEquals(1000, energy.value());

        energy.changeValue(v -> v - 999);

        assertEquals(1, energy.value());
    }
}