package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record ReAffect() implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        genome.affect(owner);
    }

    @Override
    public void affect(Alive owner) {
    }
}
