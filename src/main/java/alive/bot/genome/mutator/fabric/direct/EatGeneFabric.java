package alive.bot.genome.mutator.fabric.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Eat;
import alive.bot.genome.mutator.fabric.GeneFabric;

public class EatGeneFabric implements GeneFabric {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Eat();
    }
}
