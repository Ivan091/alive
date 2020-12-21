package alive.entities.alive.bot.genome.gene;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAlive;
import alive.entities.alive.bot.energy.EnergyAliveAlive;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.qualities.position.Position;
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

    protected EnergyAlive energyAliveMock = mock(EnergyAlive.class);
    protected Position positionMock = mock(Position.class);
    protected Genome genomeMock = mock(Genome.class);

    protected Bot botSpy = spy(new BotAlive(field, new PositionEntity(1, 1),
            new EnergyAliveAlive(0), new BotLookDirection(0), genomeMock));

    protected Bot botMock = spy(new BotAlive(field, positionMock, energyAliveMock, new BotLookDirection(0), genomeMock));

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

        when(botMock.getGenome()).thenReturn(genomeMock);

        gene.run(botMock);

        verify(genomeMock, atLeastOnce()).incrementGeneIdx(intThat(x -> x != 0));
    }

    @Test
    public void isEnergyChangingCalled() {

        when(botMock.getEnergy()).thenReturn(energyAliveMock);

        gene.run(botMock);

        verify(energyAliveMock, atLeastOnce()).incrementEnergyValue(anyInt());
    }
}