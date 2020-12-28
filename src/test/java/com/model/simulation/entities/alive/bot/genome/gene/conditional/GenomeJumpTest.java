package com.model.simulation.entities.alive.bot.genome.gene.conditional;

import com.model.simulation.entities.alive.bot.genome.BotGenome;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;
import com.model.simulation.entities.alive.bot.genome.gene.GeneTest;
import com.model.simulation.entities.alive.bot.genome.mutator.factory.conditional.GenomeJumpFactory;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GenomeJumpTest extends GeneTest {

    public GenomeJumpTest() {
        super(new GenomeJumpFactory().create(5, 10));
    }

    @Test
    public void changesGeneIdxRight() {

        var genes = new Gene[]{
                mock(Gene.class),
                mock(Gene.class),
                mock(Gene.class),
        };

        var genome = new BotGenome(genes);
        when(botMock.getGenome()).thenReturn(genome);

        gene = new GenomeJump(3);
        gene.run(botMock);

        genome.runCurrentGene(botMock);
        verify(genes[0]).run(botMock);

        gene = new GenomeJump(1);

        gene.run(botMock);
        genome.runCurrentGene(botMock);
        verify(genes[1]).run(botMock);

        gene.run(botMock);
        genome.runCurrentGene(botMock);
        verify(genes[2]).run(botMock);
    }
}