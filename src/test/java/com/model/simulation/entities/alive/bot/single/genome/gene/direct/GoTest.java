package com.model.simulation.entities.alive.bot.single.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.single.BotSingle;
import com.model.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.model.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.model.simulation.entities.alive.bot.single.genome.mutator.factory.direct.GoGeneFactory;
import com.model.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.model.simulation.entities.alive.qualities.position.PositionEntity;
import com.model.simulation.entities.lifeless.LifelessBotBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GoTest extends GeneTest {


    public GoTest() {
        super(new GoGeneFactory().create(0, 0));
    }

    private void setup(int x, int y, int lookDirNum) {

        botSpy = spy(new BotSingle(field, new PositionEntity(x, y), energyAliveMock, new BotLookDirection(lookDirNum), genomeMock));
        field.getCellsMatrix().put(botSpy);
    }


    @Test
    public void isGoingRight() {

        setup(1, 1, 0);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 1), botSpy.getPosition());
    }

    @Test
    public void isGoingUpRight() {

        setup(1, 1, 1);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 2), botSpy.getPosition());
    }

    @Test
    public void isGoingUp() {

        setup(0, 0, 2);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 1), botSpy.getPosition());
    }

    @Test
    public void isGoingUpLeft() {

        setup(1, 1, 3);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 2), botSpy.getPosition());
    }

    @Test
    public void isGoingLeft() {

        setup(1, 1, 4);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 1), botSpy.getPosition());
    }

    @Test
    public void isGoingDownLeft() {

        setup(1, 1, 5);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 0), botSpy.getPosition());
    }

    @Test
    public void isGoingDown() {

        setup(1, 1, 6);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(1, 0), botSpy.getPosition());
    }

    @Test
    public void isGoingDownRight() {

        setup(1, 1, 7);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 0), botSpy.getPosition());
    }


    @Test
    public void fieldTopLimitsBlockGoing() {

        setup(2, 2, 1);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(2, 2), botSpy.getPosition());
    }

    @Test
    public void fieldBottomLimitsBlockGoing() {

        setup(0, 0, 5);

        gene.run(botSpy);

        Assertions.assertEquals(new PositionEntity(0, 0), botSpy.getPosition());
    }

    @Test
    public void entitiesBlockGoing() {

        setup(1, 1, 0);

        matrixEntities.put(new LifelessBotBody(new PositionEntity(2, 1), new EnergyEntity(0)));
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 1), botSpy.getPosition());

        var botMock = mock(Bot.class);
        when(botMock.getPosition()).thenReturn(new PositionEntity(2, 1));
        matrixEntities.put(botMock);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 1), botSpy.getPosition());
    }
}