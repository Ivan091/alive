package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Positionable;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import org.springframework.stereotype.Component;


@Component
public final class Go implements Factory<Gene> {

    @Override
    public Gene create() {
        return new GeneSequence(
                Positionable::goAhead,
                new Heal(-510),
                new IfThen(
                        true,
                        new ReAffect()
                )
        );
    }
}
