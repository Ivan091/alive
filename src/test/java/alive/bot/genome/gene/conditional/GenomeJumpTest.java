package alive.bot.genome.gene.conditional;

import alive.bot.energy.BotEnergy;
import alive.bot.genome.BotGenome;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.Bot;
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
        var botMock = mock(Bot.class);
        when(botMock.getGenome()).thenReturn(genome);
        when(botMock.getEnergy()).thenReturn(mock(BotEnergy.class));

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