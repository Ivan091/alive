package model.bot.gen.direct_gen;

import model.bot.gen.IGen;

public abstract class DirectGen implements IGen {

    @Override
    public boolean equals(Object obj) {

        return obj.getClass() == this.getClass();
    }
}
