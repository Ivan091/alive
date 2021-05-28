package alive.genome;

import alive.entity.Alive;


public interface Genome {

    Genome replicate();

    void affect(Alive alive);

    void incrementGeneIndex(int increment);
}
