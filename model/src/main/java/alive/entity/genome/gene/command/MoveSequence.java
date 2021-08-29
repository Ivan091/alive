package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Move;


public record MoveSequence(Move... moves) implements Move {

    @Override
    public void affect(Alive owner) {
        for (var move : moves) {
            move.affect(owner);
        }
    }
}
