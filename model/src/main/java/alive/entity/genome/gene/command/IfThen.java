package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record IfThen(boolean condition, Gene gene) implements Gene {

    @Override
    public void affect(Alive owner) {
        if (condition) {
            gene.affect(owner);
        }
    }

    @Override
    public void affect(Alive owner, Genome genome) {
        if (condition) {
            gene.affect(owner, genome);
        }
    }
}
