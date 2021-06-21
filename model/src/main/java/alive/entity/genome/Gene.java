package alive.entity.genome;

import alive.entity.Alive;


public interface Gene {

    void affect(Alive alive, Genome genome);
}
