package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;


public record Heal(int heal) implements Gene {

    @Override
    public void affect(Alive owner) {
        owner.heal(heal);
    }
}