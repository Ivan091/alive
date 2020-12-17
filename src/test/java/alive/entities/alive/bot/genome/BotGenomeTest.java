package alive.entities.alive.bot.genome;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.genome.gene.Gene;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BotGenomeTest {

    private final Gene[] genes = new Gene[]{

            mock(Gene.class),
            mock(Gene.class),
            mock(Gene.class),
    };

    private final Bot botMock = mock(Bot.class);


    private final Genome genome = new BotGenome(genes);

    @Test
    void incrementGenIdx() {
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
}