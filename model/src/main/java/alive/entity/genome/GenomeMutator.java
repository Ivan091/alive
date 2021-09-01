package alive.entity.genome;

import org.springframework.stereotype.Component;
import java.util.*;
import java.util.function.Supplier;


@Component
public final class GenomeMutator implements Mutator<Gene[]> {

    private final List<Supplier<Gene>> factories;

    private final Random r = new Random();

    public GenomeMutator(List<Supplier<Gene>> factories) {
        this.factories = factories;
    }

    @Override
    public Gene[] mutate(Gene[] mutated) {
        if (r.nextInt(100) > 25) {
            return mutated;
        }
        var newGenes = Arrays.copyOf(mutated, mutated.length);
        var mutatedIdx = r.nextInt(mutated.length);
        newGenes[mutatedIdx] = factories.get(r.nextInt(factories.size())).get();
        return newGenes;
    }
}
