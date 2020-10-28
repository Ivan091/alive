package alive.bot.genome.fabric.direct;

import alive.bot.genome.fabric.GeneFabric;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Eat;

public class EatGeneFabric implements GeneFabric {

    @Override
    public Gene create(int key) {

        return new Eat();
    }
}
