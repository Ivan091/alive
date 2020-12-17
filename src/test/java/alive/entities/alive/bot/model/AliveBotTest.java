package alive.entities.alive.bot.model;

import alive.WorldConstants;
import alive.entities.alive.Alive;
import alive.entities.alive.bot.AliveBot;
import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.BotEnergy;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.qualities.direction.LookDirection;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;
import alive.field.Field;
import alive.field.MainField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class AliveBotTest {

    Field field = new MainField(1, 2);

    Position botPos = new PositionEntity(0, 0);

    LookDirection botLookDir = new BotLookDirection();

    @Mock
    Genome genomeMock = mock(Genome.class);

    @Mock
    BotEnergy energyMock = mock(BotEnergy.class);


    private Bot getBotSpy() {
        Bot bot = spy(new AliveBot(field, botPos, 0, botLookDir, genomeMock));
        addEnergyMockToBot(bot);
        field.getCellsMatrix().addEntity(bot);
        return bot;
    }

    private Bot getBotSpy(Genome genome) {
        Bot bot = spy(new AliveBot(field, botPos, 0, botLookDir, genome));
        addEnergyMockToBot(bot);
        field.getCellsMatrix().addEntity(bot);
        return bot;
    }

    private void addEnergyMockToBot(Bot bot) {
        when(bot.getEnergy()).thenReturn(energyMock);
    }


    @Test
    void createsNewBotDuringReplication() {

        var bot = getBotSpy();
        field.putEntity(bot);
        bot.replicate();
        Assertions.assertTrue(field.getCellsMatrix().getEntity(new PositionEntity(1, 0)) instanceof Alive);
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