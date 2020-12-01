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

public class GoTest extends GeneTest {


    public GoTest() {
        super(new Go());
    }

    private void setup(int x, int y, int lookDirNum) {

        bot = spy(new AliveBot(field, new BotPosition(x, y), 0, new BotLookDirection(lookDirNum), mock(Genome.class)));
    }


    @Test
    public void isGoingRight() {

        setup(1, 1, 0);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(2, 1), bot.getPosition());
    }

    @Test
    public void isGoingUpRight() {

        setup(1, 1, 1);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(2, 2), bot.getPosition());
    }

    @Test
    public void isGoingUp() {

        setup(0, 0, 2);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(0, 1), bot.getPosition());
    }

    @Test
    public void isGoingUpLeft() {

        setup(1, 1, 3);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(0, 2), bot.getPosition());
    }

    @Test
    public void isGoingLeft() {

        setup(1, 1, 4);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(0, 1), bot.getPosition());
    }

    @Test
    public void isGoingDownLeft() {

        setup(1, 1, 5);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(0, 0), bot.getPosition());
    }

    @Test
    public void isGoingDown() {

        setup(1, 1, 6);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(1, 0), bot.getPosition());
    }

    @Test
    public void isGoingDownRight() {

        setup(1, 1, 7);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(2, 0), bot.getPosition());
    }


    @Test
    public void fieldTopLimitsBlockGoing() {

        setup(2, 2, 1);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(2, 2), bot.getPosition());
    }

    @Test
    public void fieldBottomLimitsBlockGoing() {

        setup(0, 0, 5);

        gene.run(bot);

        Assertions.assertEquals(new BotPosition(0, 0), bot.getPosition());
    }

    @Test
    public void entitiesBlockGoing() {

        setup(1, 1, 0);

        cellsMatrix.setContent(new BotPosition(2, 1), new DeadBotBody(0));
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 1), bot.getPosition());

        cellsMatrix.setContent(new BotPosition(2, 1), mock(Bot.class));
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 1), bot.getPosition());
    }
}