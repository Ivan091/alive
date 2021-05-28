package alive.genome.gene;

import alive.genome.Gene;
import org.springframework.stereotype.Component;


@Component
public abstract class GeneBasic implements Gene {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
