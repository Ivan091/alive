package alive.bot.genome.gene.conditional;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class GenomeJump extends ConditionalGene {
    /**
     * @param key Using as a parameter for conditional jump.
     */
    public GenomeJump(int key) {
        super(key);
    }

    @Override
    public Gene replicate() {
        return new GenomeJump(key);
    }

    @Override
    public Boolean run(Bot bot) {
        bot.getEnergy().incrementEnergyValue(-1);
        bot.getGenome().incrementGeneIdx(key);
        return true;
    }

    @Override
    public String toString() {
        return "GenomeJump{" +
                "key=" + key +
                '}';
    }
}
