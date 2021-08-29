package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record Go() implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.goAhead();
    }
}
