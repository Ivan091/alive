package alive.bot.model;

import alive.WorldConstants;
import alive.bot.direction.look.BotLookDirection;
import alive.bot.direction.look.LookDirection;
import alive.bot.energy.Energy;
import alive.bot.genome.Genome;
import alive.bot.position.BotPosition;
import alive.bot.position.Position;
import alive.field.Field;
import alive.field.MainField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class AliveBotTest {

    Field field = new MainField(1, 2);

    Position botPos = new BotPosition(0, 0);

    LookDirection botLookDir = new BotLookDirection();

    @Mock
    Genome genomeMock = mock(Genome.class);

    @Mock
    Energy energyMock = mock(Energy.class);


    private Bot getBotSpy() {
        Bot bot = spy(new AliveBot(field, botPos, 0, botLookDir, genomeMock));
        addEnergyMockToBot(bot);
        return bot;
    }

    private Bot getBotSpy(Genome genome) {
        Bot bot = spy(new AliveBot(field, botPos, 0, botLookDir, genome));
        addEnergyMockToBot(bot);
        return bot;
    }

    private void addEnergyMockToBot(Bot bot) {
        when(energyMock.getEnergyValue()).thenReturn(0);
        when(bot.getEnergy()).thenReturn(energyMock);
    }


    @Test
    void createsNewBotDuringReplication() {

        var bot = getBotSpy();
        field.addNewAlive(bot);
        bot.replicate();
        Assertions.assertTrue(field.getCellsMatrix().getContent(new BotPosition(1, 0)) instanceof Alive);
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