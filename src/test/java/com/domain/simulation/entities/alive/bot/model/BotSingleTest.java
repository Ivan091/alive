package com.domain.simulation.entities.alive.bot.model;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.BotSingle;
import com.domain.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.direction.LookDirection;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.field.Field;
import com.domain.simulation.field.FieldLive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class BotSingleTest {

    Field field = new FieldLive(2, 1);

    Position botPos = new PositionEntity(0, 0);

    LookDirection botLookDir = new BotLookDirection();

    @Mock
    Genome genomeMock = mock(Genome.class);

    @Mock
    EnergyMortal energyMock = mock(EnergyMortal.class);

    @Test
    void createsNewBotDuringReplication() {

        var bot = getBotSpy();
        bot.replicate();
        Assertions.assertTrue(field.cellsMatrix().get(new PositionEntity(1, 0)) instanceof Bot);
        bot.replicate();
        Assertions.assertFalse(bot.isAlive());
    }

    private Bot getBotSpy() {
        return getBotSpy(genomeMock);
    }

    private Bot getBotSpy(Genome genome) {
        Bot bot = spy(new BotSingle(field, botPos, energyMock, botLookDir, genome));
        field.cellsMatrix().put(bot);
        return bot;
    }

    @Test
    void botDiesWhenThereIsNoPlaceForReplication() {
        var bot = getBotSpy();

        bot.replicate();
        bot.replicate();
        Assertions.assertFalse(bot.isAlive());
    }

    @Test
    void botDoesNotMakeTooManyMovesPerTurn() {

        when(genomeMock.runCurrentGene(any())).thenReturn(true);

        var bot = getBotSpy(genomeMock);

        bot.makeAMove();

        verify(genomeMock, times(WorldConstants.BOT_MAX_GENES_PER_MOVE)).runCurrentGene(any());
    }

    @Test
    void botDoesNotMakeAMoveIfDead() {

        when(genomeMock.runCurrentGene(any())).thenReturn(true);
        var bot = getBotSpy(genomeMock);

        bot.destroy();

        bot.makeAMove();

        verify(genomeMock, times(0)).runCurrentGene(any());
    }
}