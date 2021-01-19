package com.model.simulation.entities.alive.bot.single.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.single.BotSingle;
import com.model.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.model.simulation.entities.alive.bot.single.energy.EnergyAliveAlive;
import com.model.simulation.entities.alive.bot.single.genome.Genome;
import com.model.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.model.simulation.entities.alive.bot.single.genome.mutator.factory.direct.EatGeneFactory;
import com.model.simulation.entities.lifeless.LifelessBotBody;
import com.model.simulation.entities.qualities.energy.EnergyEntity;
import com.model.simulation.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EatTest extends GeneTest {

    public EatTest() {
        super(new EatGeneFactory().create(0, 0));
    }

    private Bot botSetup(int x, int y, int lookDirNum) {

        var bot = spy(new BotSingle(field, new PositionEntity(x, y), new EnergyAliveAlive(100), new BotLookDirection(lookDirNum), mock(Genome.class)));
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