package alive.bot.genome.mutator.fabric.conditional;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.conditional.GenomeJump;
import alive.bot.genome.mutator.fabric.GeneFabric;

public class GenomeJumpFabric implements GeneFabric {
    @Override
    public Gene create(int key, int genomeLength) {
        key = key % genomeLength;
        return new GenomeJump(key);
    }
}
