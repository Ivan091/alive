package alive.bot.genome.fabric.direct;

import alive.bot.genome.fabric.GeneFabric;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Go;

public class GoGeneFabric implements GeneFabric {

    @Override
    public Gene create(int key) {

        return new Go();
    }
}
