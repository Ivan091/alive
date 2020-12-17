package alive.entities.alive.bot.genome.gene;

import alive.entities.alive.bot.AliveBot;
import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.BotEnergy;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.qualities.position.PositionEntity;
import alive.field.Field;
import alive.field.MainField;
import alive.field.cells.CellsMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public abstract class GeneTest {

    protected Field field = new MainField(3, 3);
    protected CellsMatrix cellsMatrix = field.getCellsMatrix();
    protected Gene gene;
    protected Bot bot = createBotSpy();

    public GeneTest(Gene gene) {
        this.gene = gene;
    }

    @Test
    public void replicateTest() {
        var newGene = gene.replicate();
        Assertions.assertEquals(gene.getClass(), newGene.getClass());
    }

    @Test
    public void isGenomeIdxIncrementCalled() {

        var genome = mock(Genome.class);
        when(bot.getGenome()).thenReturn(genome);
        when(bot.getEnergy()).thenReturn(mock(BotEnergy.class));

        gene.run(bot);

        verify(genome).incrementGeneIdx(intThat(x -> x != 0));
    }

    @Test
    public void isEnergyChangingCalled() {

        var energy = new BotEnergy() {

            public boolean isEnergyValueChanged = false;

            @Override
            public int getEnergyValue() {
                return 0;
            }

            @Override
            public void setEnergyValue(int newValue) {
                isEnergyValueChanged = true;
            }

            @Override
            public void incrementEnergyValue(int increment) {
                setEnergyValue(0);
            }

            @Override
            public void notifyAlive() {

            }
        };

        when(bot.getEnergy()).thenReturn(energy);
        when(bot.getGenome()).thenReturn(mock(Genome.class));

        gene.run(bot);

        Assertions.assertTrue(energy.isEnergyValueChanged);
    }

    private Bot createBotSpy() {

        bot = spy(new AliveBot(new MainField(3, 3),
                new PositionEntity(1, 1), 0, new BotLookDirection(0), mock(Genome.class)));

        return bot;
    }
}