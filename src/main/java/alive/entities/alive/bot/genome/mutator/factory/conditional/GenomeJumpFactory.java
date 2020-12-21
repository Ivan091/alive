package alive.entities.alive.bot.genome.mutator.factory.conditional;

import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.conditional.GenomeJump;
import alive.entities.alive.bot.genome.mutator.factory.GeneFactory;

public class GenomeJumpFactory implements GeneFactory {
    @Override
    public Gene create(int key, int genomeLength) {
        if (genomeLength < 4) {
            key = 1;
        } else {
            key = key % (genomeLength / 4);
        }
        return new GenomeJump(key);
    }
}
