package alive.entities.alive.bot.genome.mutator.factory.conditional;

import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.conditional.Rotating;
import alive.entities.alive.bot.genome.mutator.factory.GeneFactory;

public class RotatingGeneFactory implements GeneFactory {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Rotating((Math.abs(key) % 8) - 3);
    }
}
