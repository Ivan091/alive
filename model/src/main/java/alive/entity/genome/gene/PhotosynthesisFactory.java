package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.genome.Gene;
import org.springframework.stereotype.Component;
import java.util.Random;


@Component
public final class PhotosynthesisFactory implements Factory<Gene> {

    @Override
    public Gene create() {
        return new IndexJump(new Random().nextInt(8) + 1);
    }
}
