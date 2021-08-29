package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.Color;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import java.util.function.UnaryOperator;


public record Paint(UnaryOperator<Color> paint) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.repaint(paint);
    }
}
