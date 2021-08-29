package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import org.springframework.stereotype.Component;


@Component
public final class Photosynthesis implements Factory<Gene> {

    private final int heal = 250;

    private final Gene gene = new GeneSequence(
            new Paint(c -> c.remix(-heal / 128, heal / 60, -heal / 128)),
            new Heal(heal),
            new IndexIncrement(1)
    );

    @Override
    public Gene create() {
        return gene;
    }
}
