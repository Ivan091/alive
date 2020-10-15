package alive.bot.genome.gen.direct;

import alive.bot.genome.gen.Gen;

public abstract class DirectGen implements Gen {

    @Override
    public boolean equals(Object obj) {

        return obj.getClass() == this.getClass();
    }
}
