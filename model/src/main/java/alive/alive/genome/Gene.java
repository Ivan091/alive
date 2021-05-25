package alive.alive.genome;

import alive.alive.Alive;


public interface Gene {

    void affect(Alive alive, Genome genome);

    Gene reproduce();
}
