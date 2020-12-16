package alive.bot.genome.gene.direct;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.energy.EntityEnergy;
import alive.bot.genome.Genome;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.AliveBot;
import alive.bot.model.Bot;
import alive.bot.position.EntityPosition;
import alive.field.cells.content.DeadBotBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EatTest extends GeneTest {

    public EatTest() {
        super(new Eat());
    }

    private Bot botSetup(int x, int y, int lookDirNum) {

        var bot = spy(new AliveBot(field, new EntityPosition(x, y), 0, new BotLookDirection(lookDirNum), mock(Genome.class)));

        doNothing().when(bot).destroy();
        doNothing().when(bot).replicate();
        when(bot.isAlive()).thenReturn(true);

        return bot;
    }

    @Test
    public void eatingEraseEntityFromField() {

        var bot = botSetup(0, 0, 0);
        var lookPos = bot.getLookDirection().getLookingPos(bot.getPosition());

        cellsMatrix.addEntity(new DeadBotBody(lookPos, new EntityEnergy(0)));
        gene.run(bot);
        Assertions.assertTrue(cellsMatrix.isEmpty(lookPos));

        cellsMatrix.addEntity(botSetup(2, 1, 0));
        gene.run(bot);
        Assertions.assertTrue(cellsMatrix.isEmpty(lookPos));
    }

    @Test
    public void eatingIncreasesEnergyValue() {

        var bot = botSetup(0, 0, 0);
        var bot2 = spy(new AliveBot(field, new EntityPosition(1, 0),
                100, new BotLookDirection(0), mock(Genome.class)));
        cellsMatrix.addEntity(bot);
        cellsMatrix.addEntity(bot2);

        gene.run(bot);
        Assertions.assertTrue(bot.getEnergy().getEnergyValue() > 0);
    }
}