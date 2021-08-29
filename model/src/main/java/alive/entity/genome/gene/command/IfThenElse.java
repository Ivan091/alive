package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record IfThenElse(boolean condition, Gene ifTrue, Gene ifFalse) implements Gene {

    @Override
    public void affect(Alive owner) {
        if (condition) {
            ifTrue.affect(owner);
        } else {
            ifFalse.affect(owner);
        }
    }

    @Override
    public void affect(Alive owner, Genome genome) {
        if (condition) {
            ifTrue.affect(owner, genome);
        } else {
            ifFalse.affect(owner, genome);
        }
    }
}
