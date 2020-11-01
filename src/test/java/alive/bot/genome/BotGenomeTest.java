package alive.bot.genome;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Photosynthesis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotGenomeTest {

    private Gene[] genes = new Gene[]{

            new Photosynthesis(),
            new Photosynthesis(),
            new Photosynthesis(),
    };

    private Genome genome = new BotGenome(genes);

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

        var newGenome = genome.replicate();

        var gene0 = newGenome.getCurrentGene();
        assertNotNull(gene0);

        do {
            newGenome.incrementGeneIdx(1);
            assertNotNull(newGenome.getCurrentGene());
        } while (gene0 != newGenome.getCurrentGene());
    }
}