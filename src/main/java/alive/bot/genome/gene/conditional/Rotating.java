package alive.bot.genome.gene.conditional;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Rotating extends ConditionalGene {

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public Rotating(int key) {

        super(key);

        key = Math.abs(key);
        this.key = (key % 8) - 3;
    }

    @Override
    public boolean run(Bot bot) {

        bot.getLookDirection().rotate(key);
        bot.getEnergy().changeEnergyValue(-5 * Math.abs(key));
        return false;
    }

    @Override
    public Gene replicate() {

        return new Rotating(key);
    }
}
