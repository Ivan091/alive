package com.model.simulation.entities.alive.bot.genome.gene;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.BotAlive;
import com.model.simulation.entities.alive.bot.direction.BotLookDirection;
import com.model.simulation.entities.alive.bot.energy.EnergyAlive;
import com.model.simulation.entities.alive.bot.energy.EnergyAliveAlive;
import com.model.simulation.entities.alive.bot.genome.Genome;
import com.model.simulation.entities.qualities.position.Position;
import com.model.simulation.entities.qualities.position.PositionEntity;
import com.model.simulation.field.Field;
import com.model.simulation.field.FieldLive;
import com.model.simulation.field.matrix.MatrixEntities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public abstract class GeneTest {

    protected Field field = new FieldLive(3, 3);
    protected MatrixEntities matrixEntities = field.getCellsMatrix();
    protected Gene gene;

    protected EnergyAlive energyAliveMock = mock(EnergyAlive.class);
    protected Position positionMock = mock(Position.class);
    protected Genome genomeMock = mock(Genome.class);

    protected Bot botSpy = spy(new BotAlive(field, new PositionEntity(1, 1),
            new EnergyAliveAlive(0), new BotLookDirection(0), genomeMock));

    protected Bot botMock = spy(new BotAlive(field, positionMock,
            energyAliveMock, new BotLookDirection(0), genomeMock));

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

        gene.run(botMock);

        verify(genomeMock, atLeastOnce()).incrementGeneIdx(intThat(x -> x != 0));
    }

    @Test
    public void isEnergyChangingCalled() {

        gene.run(botMock);

        verify(energyAliveMock, atLeastOnce()).incrementEnergyValue(anyInt());
    }
}