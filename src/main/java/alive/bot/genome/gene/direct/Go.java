package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Go extends AbstractDirectGene {

    @Override
    public boolean run(Bot bot) {

        var lookingPos = bot.getLookDirection().getLookingPos(bot.getPosition());

        var cells = bot.getField().getCells();
        if (cells.isInBoundsAndEmpty(lookingPos)) {
            cells.setEmpty(bot.getPosition());
            bot.setPosition(lookingPos);
            cells.setContent(bot.getPosition(), bot);
        }

        bot.getEnergy().incrementEnergyValue(-2);
        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Go();
    }
}
