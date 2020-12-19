package alive.entities.alive.bot.genome.gene.conditional;

import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyBot;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.alive.bot.genome.gene.GeneTest;
import alive.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RotatingTest extends GeneTest {

    public RotatingTest() {
        super(new Rotating(0));
    }

    private void setup(int geneArg) {

        gene = new Rotating(geneArg);
        bot = spy(new BotAlive(field, new PositionEntity(1, 1),
                mock(EnergyBot.class), new BotLookDirection(0), mock(Genome.class)));
        when(bot.isAlive()).thenReturn(true);
    }

    @Test
    public void noRotation() {

        setup(0);
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(2, 1), bot.getLookingPos().orElseThrow());

    }

    @Test
    public void rotateRight1Step() {

        setup(-1);

        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(2, 0), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 0), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(0, 0), bot.getLookingPos().orElseThrow());
    }

    @Test
    public void rotateRight2Steps() {

        setup(-2);
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 0), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(0, 1), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 2), bot.getLookingPos().orElseThrow());
    }

    @Test
    public void rotateRight3Steps() {

        setup(-3);
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(0, 0), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 2), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(2, 0), bot.getLookingPos().orElseThrow());
    }

    @Test
    public void rotateLeft1Step() {

        setup(1);
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(2, 2), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 2), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(0, 2), bot.getLookingPos().orElseThrow());
    }

    @Test
    public void rotateLeft2Steps() {

        setup(2);
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 2), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(0, 1), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 0), bot.getLookingPos().orElseThrow());
    }

    @Test
    public void rotateLeft3Steps() {

        setup(3);
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(0, 2), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(1, 0), bot.getLookingPos().orElseThrow());
        gene.run(bot);
        Assertions.assertEquals(new PositionEntity(2, 2), bot.getLookingPos().orElseThrow());
    }
}