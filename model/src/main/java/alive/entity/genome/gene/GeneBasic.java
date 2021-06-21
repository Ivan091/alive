package alive.entity.genome.gene;

import alive.entity.genome.Gene;
import org.springframework.stereotype.Component;


@Component
public abstract class GeneBasic implements Gene {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
