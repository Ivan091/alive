package alive.genome;

import alive.entity.Alive;


public interface Genome {

    void affect(Alive alive);

    void incrementGeneIndex(int increment);
}
