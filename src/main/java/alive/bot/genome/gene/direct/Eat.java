package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public class Eat extends DirectGene {

    @Override
    public boolean run(Bot bot) {

        try {
            var lookingPos = bot.getLookDirection().getLookingPos(bot.getPosition());
            var eatingContent = bot.getField().getCells().
                    getCellContent(lookingPos);
            bot.getField().getCells().setEmpty(lookingPos);
            bot.getEnergy().incrementEnergyValue(eatingContent.getEnergyValue() >> 1);
        } catch (IllegalArgumentException e) {
            //System.out.println(e.getMessage());
        }

        bot.getGenome().incrementGenIdx(1);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Eat();
    }
}
