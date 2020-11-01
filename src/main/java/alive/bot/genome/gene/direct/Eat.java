package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Eat extends DirectGene {

    @Override
    public boolean run(Bot bot) {

        var lookingPos = bot.getLookDirection().getLookingPos(bot.getPosition());
        var cells = bot.getField().getCells();

        if (cells.isInBounds(lookingPos)) {

            var eatingContent = cells.getCellContent(lookingPos);
            cells.setEmpty(lookingPos);
            bot.getEnergy().incrementEnergyValue(eatingContent.getEnergyValue() >> 1);
        } else {

            bot.getEnergy().incrementEnergyValue(-10);
        }

        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Eat();
    }
}
