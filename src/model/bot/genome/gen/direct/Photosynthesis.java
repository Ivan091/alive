package model.bot.genome.gen.direct;

import model.Field;
import model.bot.Bot;

public class Photosynthesis extends DirectGen {

    @Override
    public boolean run(Bot bot, Field field) {

        bot.genome.moveNext(1);
        bot.energy.changeEnergyValue(10);
        return false;
    }
}
