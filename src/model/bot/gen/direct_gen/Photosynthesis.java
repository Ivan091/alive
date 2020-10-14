package model.bot.gen.direct_gen;

import model.bot.Bot;
import model.Field;

public class Photosynthesis extends DirectGen {

    @Override
    public boolean run(Bot bot, Field field) {

        bot.addToCurrentGenIndexSave(1);

        bot.getEnergy().changeEnergyValue(-100);

        return false;
    }
}
