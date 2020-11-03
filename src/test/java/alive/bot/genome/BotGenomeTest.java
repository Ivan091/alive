package alive.bot.genome;

import alive.bot.genome.gene.Gene;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BotGenomeTest {

    private final Gene[] genes = new Gene[]{

            mock(Gene.class),
            mock(Gene.class),
            mock(Gene.class),
    };

    private final Genome genome = new BotGenome(genes);

    @Test
    void incrementGenIdx() {

        var gene0 = genome.getCurrentGene();

        genome.incrementGeneIdx(1);
        assertSame(genes[1], genome.getCurrentGene());

        genome.incrementGeneIdx(-1);
        assertSame(gene0, genome.getCurrentGene());

        genome.incrementGeneIdx(genes.length);
        assertSame(gene0, genome.getCurrentGene());

        genome.incrementGeneIdx(-1);
        assertSame(genes[genes.length - 1], genome.getCurrentGene());

        genome.incrementGeneIdx(1);
        assertSame(gene0, genome.getCurrentGene());
    }

    @Test
    void allReplicatedGenesNotNull() {

        Arrays.stream(genes).forEach(x -> when(x.replicate()).thenReturn(mock(Gene.class)));

        var newGenome = genome.replicate();

        var gene0 = newGenome.getCurrentGene();
        assertNotNull(gene0);

        do {
            newGenome.incrementGeneIdx(1);

            assertNotNull(newGenome.getCurrentGene());
        } while (gene0 != newGenome.getCurrentGene());
    }

    @Test
    void throwsExceptionIfGenesCountLessThan1() {

        var genes0 = new Gene[]{};

        assertThrows(IllegalArgumentException.class, () -> new BotGenome(genes0));
    }
}