package com.domain.simulation.entities.alive.bot.single.genome.gene.direct;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.BotSingle;
import com.domain.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.domain.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.direct.GoGeneFactory;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.entities.lifeless.LifelessBotBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GoTest extends GeneTest {


    public GoTest() {
        super(new GoGeneFactory().create(0, 0));
    }

    @Test
    public void isGoingRight() {

        setup(1, 1, 0);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 1), botSpy.position());
    }

    private void setup(int x, int y, int lookDirNum) {

        botSpy = spy(new BotSingle(field, new PositionEntity(x, y), energyMortalMock, new BotLookDirection(lookDirNum), genomeMock));
        field.getCellsMatrix().put(botSpy);
    }

    @Test
    public void isGoingUpRight() {

        setup(1, 1, 1);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 2), botSpy.position());
    }

    @Test
    public void isGoingUp() {

        setup(0, 0, 2);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 1), botSpy.position());
    }

    @Test
    public void isGoingUpLeft() {

        setup(1, 1, 3);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 2), botSpy.position());
    }

    @Test
    public void isGoingLeft() {

        setup(1, 1, 4);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 1), botSpy.position());
    }

    @Test
    public void isGoingDownLeft() {

        setup(1, 1, 5);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 0), botSpy.position());
    }

    @Test
    public void isGoingDown() {

        setup(1, 1, 6);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(1, 0), botSpy.position());
    }

    @Test
    public void isGoingDownRight() {

        setup(1, 1, 7);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 0), botSpy.position());
    }


    @Test
    public void fieldTopLimitsBlockGoing() {

        setup(2, 2, 1);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 2), botSpy.position());
    }

    @Test
    public void fieldBottomLimitsBlockGoing() {

        setup(0, 0, 5);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 0), botSpy.position());
    }

    @Test
    public void entitiesBlockGoing() {

        setup(1, 1, 0);

        matrixEntities.put(new LifelessBotBody(new PositionEntity(2, 1), new EnergyEntity(0)));
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 1), botSpy.position());

        var botMock = mock(Bot.class);
        when(botMock.position()).thenReturn(new PositionEntity(2, 1));
        matrixEntities.put(botMock);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 1), botSpy.position());
    }
}