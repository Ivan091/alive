package alive.bot.genome.mutator.fabric.conditional;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.conditional.Rotating;
import alive.bot.genome.mutator.fabric.GeneFabric;

public class RotatingGeneFabric implements GeneFabric {

    @Override
    public Gene create(int key) {

        return new Rotating(key);
    }
}
