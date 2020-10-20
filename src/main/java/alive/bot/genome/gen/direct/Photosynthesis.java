package alive.bot.genome.gen.direct;

import alive.bot.model.Bot;
import alive.field.Field;

public class Photosynthesis extends DirectGen {

    @Override
    public boolean run(Bot bot, Field field) {

        bot.getGenome().incrementGenIdx(1);
        bot.getEnergy().changeEnergyValue(10);
        return false;
    }
}