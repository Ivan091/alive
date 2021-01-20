package com.domain.simulation.entities.alive.bot.single.genome;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.alive.bot.single.genome.gene.direct.Photosynthesis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BotGenomeTest {

    private final Bot botMock = mock(Bot.class);
    private Gene[] genes = new Gene[]{

            mock(Gene.class),
            mock(Gene.class),
            mock(Gene.class),
    };
    private Genome genome = new BotGenome(genes);

    @Test
    void incrementGeneIdx() {
        genome.incrementGeneIdx(1);
        genome.runCurrentGene(botMock);
        verify(genes[1]).run(botMock);

        genome.incrementGeneIdx(-1);
        genome.runCurrentGene(botMock);
        verify(genes[0]).run(botMock);

        genome.incrementGeneIdx(genes.length);
        genome.runCurrentGene(botMock);
        verify(genes[0], times(2)).run(botMock);

        genome.incrementGeneIdx(-1);
        genome.runCurrentGene(botMock);
        verify(genes[genes.length - 1]).run(botMock);

        genome.incrementGeneIdx(1);
        genome.runCurrentGene(botMock);
        verify(genes[0], times(3)).run(botMock);
    }

    @Test
    void throwsExceptionIfGenesCountLessThan1() {

        var genes0 = new Gene[]{};

        assertThrows(IllegalArgumentException.class, () -> new BotGenome(genes0));
    }

    @Test
    void length() {
        Assertions.assertEquals(genes.length, genome.length());
    }

    @Test
    void allReplicatedGenesNotNull() {

        genes = new Gene[]{new Photosynthesis(), new Photosynthesis()};
        genome = new BotGenome(genes);
        IntStream.range(0, 200).forEach(i ->
                Assertions.assertDoesNotThrow(() -> genome = genome.replicate()));
    }
}