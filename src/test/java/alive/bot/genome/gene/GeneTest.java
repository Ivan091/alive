package alive.bot.genome.gene;

import alive.bot.energy.Energy;
import alive.bot.genome.Genome;
import alive.bot.model.Bot;

import static org.mockito.Mockito.*;

public class GeneTest {

    public static void isGenomeIncrementCalled(Gene gene) {

        var bot = mock(Bot.class);
        var genome = mock(Genome.class);

        when(bot.getEnergy()).thenReturn(mock(Energy.class));
        when(bot.getGenome()).thenReturn(genome);

        gene.run(bot);

        verify(genome).incrementGeneIdx(intThat(x -> x != 0));
    }
}