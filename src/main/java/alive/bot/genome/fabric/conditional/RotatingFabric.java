package alive.bot.genome.fabric.conditional;

import alive.bot.genome.fabric.GeneFabric;
import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.conditional.Rotating;

public class RotatingFabric implements GeneFabric {

    @Override
    public Gene create(int key) {

        return new Rotating(key);
    }
}
