package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Photosynthesis extends AbstractDirectGene {

    @Override
    public Boolean run(Bot bot) {

        bot.getEnergy().incrementEnergyValue(57);
        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Photosynthesis();
    }
}