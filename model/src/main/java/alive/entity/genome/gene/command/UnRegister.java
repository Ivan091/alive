package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;


public class UnRegister implements Gene {

    @Override
    public void affect(Alive owner) {
        owner.unregister();
    }
}
