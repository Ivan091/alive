package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Go extends DirectGene {

    @Override
    public boolean run(Bot bot) {

        var lookingPos = bot.getLookDirection().getLookingPos(bot.getPosition());

        var cells = bot.getField().getCells();
        if (cells.isEmpty(lookingPos)) {
            cells.setEmpty(bot.getPosition());
            bot.setPosition(lookingPos);
            cells.setCellContent(bot.getPosition(), bot);
        }

        bot.getGenome().incrementGenIdx(1);
        bot.getEnergy().incrementEnergyValue(-5);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Go();
    }
}
