package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record IfTrue(boolean condition, Gene... genes) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        if (condition) {
            for (var gene : genes) {
                gene.affect(owner, genome);
            }
        }
    }
}
