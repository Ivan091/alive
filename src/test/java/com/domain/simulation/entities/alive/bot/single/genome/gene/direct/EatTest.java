package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.BotSingle;
import com.domain.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyAliveMortal;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.direct.EatGeneFactory;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.entities.lifeless.LifelessBotBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EatTest extends GeneTest {

    public EatTest() {
        super(new EatGeneFactory().create(0, 0));
    }

    @Test
    public void eatingEraseEntityFromField() {

        var bot = botSetup(0, 0, 0);
        var lookPos = bot.lookDirection().getLookingPos(bot.position());

        matrixEntities.put(new LifelessBotBody(lookPos, new EnergyEntity(0)));
        gene.run(bot);
        Assertions.assertTrue(matrixEntities.isEmpty(lookPos));

        matrixEntities.put(botSetup(2, 1, 0));
        gene.run(bot);
        Assertions.assertTrue(matrixEntities.isEmpty(lookPos));
    }

    private Bot botSetup(int x, int y, int lookDirNum) {

        return spy(new BotSingle(field, new PositionEntity(x, y), new EnergyAliveMortal(100), new BotLookDirection(lookDirNum), mock(Genome.class)));
    }

    @Test
    public void eatingIncreasesEnergyValue() {

        var bot = botSetup(0, 0, 0);
        var bot2 = botSetup(1, 0, 0);

        matrixEntities.put(bot);
        matrixEntities.put(bot2);

        gene.run(bot);
        Assertions.assertTrue(bot.energy().getEnergyValue() > 100);
    }
}