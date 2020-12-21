package alive.entities.alive.bot.model;

import alive.WorldConstants;
import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAlive;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.qualities.direction.LookDirection;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;
import alive.field.Field;
import alive.field.FieldLive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class BotAliveTest {

    Field field = new FieldLive(2, 1);

    Position botPos = new PositionEntity(0, 0);

    LookDirection botLookDir = new BotLookDirection();

    @Mock
    Genome genomeMock = mock(Genome.class);

    @Mock
    EnergyAlive energyMock = mock(EnergyAlive.class);

    private Bot getBotSpy(Genome genome) {
        Bot bot = spy(new BotAlive(field, botPos, energyMock, botLookDir, genome));
        field.getCellsMatrix().put(bot);
        return bot;
    }

    private Bot getBotSpy() {
        return getBotSpy(genomeMock);
    }


    @Test
    void createsNewBotDuringReplication() {

        var bot = getBotSpy();
        bot.replicate();
        Assertions.assertTrue(field.getCellsMatrix().get(new PositionEntity(1, 0)) instanceof Bot);
        bot.replicate();
        Assertions.assertFalse(bot.isAlive());
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