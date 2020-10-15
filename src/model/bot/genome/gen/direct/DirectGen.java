package model.bot.genome.gen.direct;

import model.bot.genome.gen.Gen;

public abstract class DirectGen implements Gen {

    @Override
    public boolean equals(Object obj) {

        return obj.getClass() == this.getClass();
    }
}
