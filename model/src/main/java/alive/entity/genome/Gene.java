package alive.entity.genome;

import alive.entity.Alive;


public interface Gene extends Move {

    default void affect(Alive owner, Genome genome) {
        affect(owner);
    }
}
