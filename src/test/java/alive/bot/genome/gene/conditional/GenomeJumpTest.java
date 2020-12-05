package alive.bot.genome.gene.conditional;

import alive.bot.energy.Energy;
import alive.bot.genome.BotGenome;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GenomeJumpTest extends GeneTest {

    public GenomeJumpTest() {
        super(new GenomeJump(3));
    }

    @Test
    public void changesGeneIdxRight() {

        var genes = new Gene[]{
                mock(Gene.class),
                mock(Gene.class),
                mock(Gene.class),
        };

        var genome = new BotGenome(genes);
        var bot = mock(Bot.class);
        when(bot.getGenome()).thenReturn(genome);
        when(bot.getEnergy()).thenReturn(mock(Energy.class));

        gene = new GenomeJump(3);
        gene.run(bot);
        Assertions.assertSame(genes[0], genome.getCurrentGene());

        gene = new GenomeJump(1);
        
        gene.run(bot);
        Assertions.assertSame(genes[1], genome.getCurrentGene());
        gene.run(bot);
        Assertions.assertSame(genes[2], genome.getCurrentGene());

    }
}