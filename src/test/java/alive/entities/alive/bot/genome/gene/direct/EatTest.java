package alive.entities.alive.bot.genome.gene.direct;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAliveAlive;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.alive.bot.genome.gene.GeneTest;
import alive.entities.alive.bot.genome.mutator.factory.direct.EatGeneFactory;
import alive.entities.lifeless.LifelessBotBody;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EatTest extends GeneTest {

    public EatTest() {
        super(new EatGeneFactory().create(0, 0));
    }

    private Bot botSetup(int x, int y, int lookDirNum) {

        var bot = spy(new BotAlive(field, new PositionEntity(x, y), new EnergyAliveAlive(100), new BotLookDirection(lookDirNum), mock(Genome.class)));
        return bot;
    }

    @Test
    public void eatingEraseEntityFromField() {

        var bot = botSetup(0, 0, 0);
        var lookPos = bot.getLookDirection().getLookingPos(bot.getPosition());

        matrixEntities.put(new LifelessBotBody(lookPos, new EnergyEntity(0)));
        gene.run(bot);
        Assertions.assertTrue(matrixEntities.isEmpty(lookPos));

        matrixEntities.put(botSetup(2, 1, 0));
        gene.run(bot);
        Assertions.assertTrue(matrixEntities.isEmpty(lookPos));
    }

    @Test
    public void eatingIncreasesEnergyValue() {

        var bot = botSetup(0, 0, 0);
        var bot2 = botSetup(1, 0, 0);

        matrixEntities.put(bot);
        matrixEntities.put(bot2);

        gene.run(bot);
        Assertions.assertTrue(bot.getEnergy().getEnergyValue() > 100);
    }
}