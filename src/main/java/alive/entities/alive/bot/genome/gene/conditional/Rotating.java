package alive.entities.alive.bot.genome.gene.conditional;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.genome.gene.Gene;

public class Rotating extends ConditionalGene {

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public Rotating(int key) {
        super(key);
    }

    @Override
    public Boolean run(Bot bot) {

        bot.getLookDirection().rotate(key);


        bot.getEnergy().incrementEnergyValue(-4 * Math.abs(key));
        bot.getGenome().incrementGeneIdx(1);
        return true;
    }

    @Override
    public Gene replicate() {

        return new Rotating(key);
    }

    @Override
    public String toString() {
        return "Rotating{" +
                "key=" + key +
                '}';
    }
}
