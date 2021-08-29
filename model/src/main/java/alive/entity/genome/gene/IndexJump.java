package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import org.springframework.stereotype.Component;
import java.util.Random;


@Component
public final class IndexJump implements Factory<Gene> {

    private final Random random = new Random();

    @Override
    public Gene create() {
        var key = random.nextInt(8) + 1;
        return new GeneSequence(
                new IndexIncrement(key),
                new Heal(-key * 10),
                new IfThen(
                        true,
                        new ReAffect()
                )
        );
    }
}
