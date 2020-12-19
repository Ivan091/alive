package alive.entities.alive.bot.genome.gene.direct;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.genome.gene.Gene;

public class Go extends DirectGene {

    @Override
    public Boolean run(Bot bot) {

        var lookingPos = bot.getLookingPos();
        var cells = bot.getField().getCellsMatrix();
        lookingPos.ifPresent(pos -> {
            if (cells.isEmpty(pos)) {
                cells.putEmpty(bot.getPosition());
                bot.setPosition(pos);
                cells.putEntity(bot);
            }
        });

        bot.getEnergy().incrementEnergyValue(-2);
        bot.getGenome().incrementGeneIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Go();
    }
}
