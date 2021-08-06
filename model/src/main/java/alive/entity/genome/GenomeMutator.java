package alive.entity.genome;

import alive.common.Factory;
import org.springframework.stereotype.Component;
import java.util.*;


@Component
public final class GenomeMutator implements Mutator<Gene[]> {

    private final List<Factory<Gene>> factories;

    private final Random r = new Random();

    public GenomeMutator(List<Factory<Gene>> factories) {
        this.factories = factories;
    }

    @Override
    public Gene[] mutate(Gene[] mutated) {
        if (r.nextInt(100) > 40) {
            return mutated;
        }
        var mutatedIdx = r.nextInt(mutated.length);
        var newGenes = Arrays.copyOf(mutated, mutated.length);
        newGenes[mutatedIdx] = factories.get(r.nextInt(factories.size())).create();
        return newGenes;
    }
}
