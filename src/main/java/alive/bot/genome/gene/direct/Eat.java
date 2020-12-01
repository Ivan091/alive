package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Eat extends AbstractDirectGene {

    @Override
    public Boolean run(Bot bot) {

        var lookingPos = bot.getLookingPos();
        var cells = bot.getField().getCells();

        if (cells.isInBounds(lookingPos)) {

            var eatingContent = cells.getContent(lookingPos);
            cells.setEmpty(lookingPos);

            bot.getEnergy().incrementEnergyValue(eatingContent.getEnergyValue() >> 1);
        }

        bot.getEnergy().incrementEnergyValue(-2);
        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Eat();
    }
}
