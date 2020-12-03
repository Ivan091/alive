package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.Gene;

public abstract class DirectGene implements Gene {

    @Override
    public boolean equals(Object obj) {

        return obj.getClass() == this.getClass();
    }
}
