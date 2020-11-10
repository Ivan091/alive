package alive.bot.genome.gene.conditional;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Rotating extends AbstractConditionalGene {

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public Rotating(int key) {

        super(key);

        this.key = (Math.abs(key) % 8) - 3;
    }

    @Override
    public boolean run(Bot bot) {

        bot.getLookDirection().rotate(key);


        bot.getEnergy().incrementEnergyValue(-5 * Math.abs(key));
        bot.getGenome().incrementGeneIdx(1);
        return true;
    }

    @Override
    public Gene replicate() {

        return new Rotating(key);
    }
}
