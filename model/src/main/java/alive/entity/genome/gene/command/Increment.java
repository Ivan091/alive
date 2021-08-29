package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record Increment(int increment) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        genome.incrementGeneIndex(increment);
    }
}
