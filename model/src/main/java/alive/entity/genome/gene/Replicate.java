package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.GeneSequence;
import alive.entity.genome.gene.command.IndexIncrement;
import org.springframework.stereotype.Component;


@Component
public final class Replicate implements Factory<Gene> {

    private final Gene replicate = new GeneSequence(
            Alive::replicate,
            new IndexIncrement(1)
    );

    @Override
    public Gene create() {
        return replicate;
    }
}
