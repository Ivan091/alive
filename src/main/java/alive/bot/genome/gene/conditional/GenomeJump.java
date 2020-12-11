package alive.bot.genome.gene.conditional;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class GenomeJump extends ConditionalGene {
    /**
     * @param key Using as a parameter for conditional jump.
     */
    public GenomeJump(int key) {
        super(key);
        this.key = key == 0 ? 1 : key;
    }

    @Override
    public Gene replicate() {
        return new GenomeJump(key);
    }

    @Override
    public Boolean run(Bot bot) {
        bot.getEnergy().incrementEnergyValue(Math.abs(key) / -2);
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
