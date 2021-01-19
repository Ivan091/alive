package com.model.simulation.entities.alive.bot.single.genome.mutator;

import com.model.simulation.entities.alive.bot.single.genome.gene.Gene;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class GenomeMutatorTest {

    private GenomeMutator mutator = new GenomeMutator();

    private Gene[] genes = new Gene[]
            {
                    mock(Gene.class),
                    mock(Gene.class),
                    mock(Gene.class),
            };

    @Test
    void mutatedItemIsNotNull() {

        Arrays.stream(genes).forEach(x -> when(x.replicate()).thenReturn(mock(Gene.class)));

        var mutatedGenes = mutator.mutate(genes);

        Arrays.stream(mutatedGenes).forEach(Assertions::assertNotNull);
    }
}