package alive.bot.genome.gene.conditional;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.genome.Genome;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.AliveBot;
import alive.bot.position.BotPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RotatingTest extends GeneTest {

    public RotatingTest() {
        super(new Rotating(0));
    }

    private void setup(int geneArg) {

        gene = new Rotating(geneArg);
        bot = spy(new AliveBot(field, new BotPosition(1, 1), 0, new BotLookDirection(0), mock(Genome.class)));

        doNothing().when(bot).destroy();
        doNothing().when(bot).replicate();
        when(bot.isAlive()).thenReturn(true);
    }

    @Test
    public void noRotation() {

        setup(0);
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(2, 1), bot.getLookingPos());

    }

    @Test
    public void rotateRight1Step() {

        setup(-1);

        gene.run(bot);
        Assertions.assertEquals(new BotPosition(2, 0), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 0), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(0, 0), bot.getLookingPos());
    }

    @Test
    public void rotateRight2Steps() {

        setup(-2);
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 0), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(0, 1), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 2), bot.getLookingPos());
    }

    @Test
    public void rotateRight3Steps() {

        setup(-3);
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(0, 0), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 2), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(2, 0), bot.getLookingPos());
    }

    @Test
    public void rotateLeft1Step() {

        setup(1);
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(2, 2), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 2), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(0, 2), bot.getLookingPos());
    }

    @Test
    public void rotateLeft2Steps() {

        setup(2);
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 2), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(0, 1), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 0), bot.getLookingPos());
    }

    @Test
    public void rotateLeft3Steps() {

        setup(3);
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(0, 2), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(1, 0), bot.getLookingPos());
        gene.run(bot);
        Assertions.assertEquals(new BotPosition(2, 2), bot.getLookingPos());
    }
}