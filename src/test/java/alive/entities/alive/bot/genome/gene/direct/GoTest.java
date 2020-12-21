package alive.entities.alive.bot.genome.gene.direct;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAlive;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.alive.bot.genome.gene.GeneTest;
import alive.entities.lifeless.LifelessBotBody;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GoTest extends GeneTest {


    public GoTest() {
        super(new Go());
    }

    private void setup(int x, int y, int lookDirNum) {

        botSpy = spy(new BotAlive(field, new PositionEntity(x, y), mock(EnergyAlive.class), new BotLookDirection(lookDirNum), mock(Genome.class)));
        field.getCellsMatrix().putEntity(botSpy);
        doReturn(mock(EnergyAlive.class)).when(botSpy).getEnergy();
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

        cellMatrix.putEntity(new LifelessBotBody(new PositionEntity(2, 1), new EnergyEntity(0)));
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 1), botSpy.getPosition());

        var botMock = mock(Bot.class);
        when(botMock.getPosition()).thenReturn(new PositionEntity(2, 1));
        cellMatrix.putEntity(botMock);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 1), botSpy.getPosition());
    }
}