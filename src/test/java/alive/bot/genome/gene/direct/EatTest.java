package alive.bot.genome.gene.direct;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.Genome;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.AliveBot;
import alive.bot.model.Bot;
import alive.bot.position.BotPosition;
import alive.field.cells.content.DeadBotBody;
import alive.field.cells.content.Empty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EatTest extends GeneTest {

    public EatTest() {
        super(new Eat());
    }

    private Bot botSetup(int x, int y, int lookDirNum) {

        var bot = spy(new AliveBot(field, new BotPosition(x, y), 0, new BotLookDirection(lookDirNum), mock(Genome.class)));

        doNothing().when(bot).destroy();
        doNothing().when(bot).replicate();
        when(bot.isAlive()).thenReturn(true);

        return bot;
    }

    @Test
    public void eatingEraseEntityFromField() {

        var bot = botSetup(0, 0, 0);
        var lookPos = bot.getLookDirection().getLookingPos(bot.getPosition());

        cellsMatrix.setContent(lookPos, mock(DeadBotBody.class));
        gene.run(bot);
        Assertions.assertTrue(cellsMatrix.isEmpty(lookPos));

        cellsMatrix.setContent(lookPos, mock(Bot.class));
        gene.run(bot);
        Assertions.assertTrue(cellsMatrix.isEmpty(lookPos));
    }

    @Test
    public void eatingIncreasesEnergyValue() {

        var bot = botSetup(0, 0, 0);
        var bot2 = spy(new AliveBot(field, new BotPosition(1, 0),
                100, new BotLookDirection(0), mock(Genome.class)));
        cellsMatrix.setContent(bot.getPosition(), bot);
        cellsMatrix.setContent(bot2.getPosition(), bot2);

        gene.run(bot);
        Assertions.assertTrue(bot.getEnergy().getEnergyValue() > 0);
        Assertions.assertEquals(new Empty(), cellsMatrix.getContent(bot2.getPosition()));
    }
}