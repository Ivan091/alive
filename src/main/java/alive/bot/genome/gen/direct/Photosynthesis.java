package alive.bot.genome.gen.direct;

import alive.bot.model.Bot;

public class Photosynthesis extends DirectGen {

    @Override
    public boolean run(Bot bot) {

        bot.getGenome().incrementGenIdx(1);
        bot.getEnergy().changeEnergyValue(-100);
        return false;
    }
}