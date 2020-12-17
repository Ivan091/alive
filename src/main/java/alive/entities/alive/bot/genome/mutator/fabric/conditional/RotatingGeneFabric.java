package alive.entities.alive.bot.genome.mutator.fabric.conditional;

import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.conditional.Rotating;
import alive.entities.alive.bot.genome.mutator.fabric.GeneFabric;

public class RotatingGeneFabric implements GeneFabric {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Rotating((Math.abs(key) % 8) - 3);
    }
}
