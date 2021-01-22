package com.domain.simulation.entities.alive.bot.single.genome.gene;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.BotSingle;
import com.domain.simulation.entities.alive.bot.single.direction.BotLookDirection;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyAliveMortal;
import com.domain.simulation.entities.alive.bot.single.energy.EnergyMortal;
import com.domain.simulation.entities.alive.bot.single.genome.Genome;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.field.Field;
import com.domain.simulation.field.FieldLive;
import com.domain.simulation.field.matrix.MatrixEntities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public abstract class GeneTest {

    protected Field field = new FieldLive(3, 3);
    protected MatrixEntities matrixEntities = field.cellsMatrix();
    protected Gene gene;

    protected EnergyMortal energyMortalMock = mock(EnergyMortal.class);
    protected Position positionMock = mock(Position.class);
    protected Genome genomeMock = mock(Genome.class);

    protected Bot botSpy = spy(new BotSingle(field, new PositionEntity(1, 1),
            new EnergyAliveMortal(0), new BotLookDirection(0), genomeMock));

    protected Bot botMock = spy(new BotSingle(field, positionMock,
            energyMortalMock, new BotLookDirection(0), genomeMock));

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

        verify(energyMortalMock, atLeastOnce()).changeValue(any());
    }
}