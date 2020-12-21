package alive.entities.alive.bot.genome.mutator.factory.direct;

import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.direct.Eat;
import alive.entities.alive.bot.genome.mutator.factory.GeneFactory;

public class EatGeneFactory implements GeneFactory {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Eat();
    }
}
