package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import org.springframework.stereotype.Component;
import java.util.Random;


@Component
public final class Rotate implements Factory<Gene> {

    private final Random random = new Random();

    @Override
    public Gene create() {
        var key = random.nextInt(8) - 3;
        return new GeneSequence(
                (o) -> o.rotate(key),
                new Heal(-key * 40),
                new IndexIncrement(1),
                new IfThen(
                        true,
                        new ReAffect()
                )
        );
    }
}
