package alive.bot.genome.gene.direct;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.Genome;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.AliveBot;
import alive.bot.model.Bot;
import alive.bot.position.BotPosition;
import alive.field.cells.content.DeadBotBody;
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
    public void canEatEntities() {

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
}