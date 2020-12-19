package alive.entities.alive.bot.genome.gene;

import alive.entities.alive.Mortal;
import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAliveBot;
import alive.entities.alive.bot.energy.EnergyBot;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.qualities.position.PositionEntity;
import alive.field.Field;
import alive.field.FieldLive;
import alive.field.cells.CellMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public abstract class GeneTest {

    protected Field field = new FieldLive(3, 3);
    protected CellMatrix cellMatrix = field.getCellsMatrix();
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
        when(bot.getEnergy()).thenReturn(mock(EnergyBot.class));

        gene.run(bot);

        verify(genome).incrementGeneIdx(intThat(x -> x != 0));
    }

    @Test
    public void isEnergyChangingCalled() {

        var energy = new EnergyBot() {

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
            public void subscribeMortal(Mortal mortal) {

            }

            @Override
            public void incrementEnergyValue(int increment) {
                setEnergyValue(0);
            }

            @Override
            public void notifyMortal() {

            }
        };

        when(bot.getEnergy()).thenReturn(energy);
        when(bot.getGenome()).thenReturn(mock(Genome.class));

        gene.run(bot);

        Assertions.assertTrue(energy.isEnergyValueChanged);
    }

    private Bot createBotSpy() {

        bot = spy(new BotAlive(new FieldLive(3, 3),
                new PositionEntity(1, 1), new EnergyAliveBot(0), new BotLookDirection(0), mock(Genome.class)));

        return bot;
    }
}