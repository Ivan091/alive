package alive.entity.genome.gene;

import alive.entity.genome.Gene;
import alive.entity.genome.Mutator;
import org.springframework.stereotype.Component;
import java.lang.reflect.Constructor;
import java.util.*;


@Component
public final class GenomeMutator implements Mutator<Gene[]> {

    private final List<Constructor<? extends Gene>> factories;

    Random r = new Random();

    public GenomeMutator(List<Gene> genes) throws Exception {
        factories = new ArrayList<>(genes.size());
        for (var gene : genes) {
            factories.add(gene.getClass().getDeclaredConstructor());
        }
    }

    @Override
    public Gene[] mutate(Gene[] mutated) {
        if (r.nextInt(100) > 40) {
            return mutated;
        }
        var mutatedIdx = r.nextInt(mutated.length);
        var newGenes = Arrays.copyOf(mutated, mutated.length);
        try {
            newGenes[mutatedIdx] = factories.get(r.nextInt(factories.size())).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newGenes;
    }
}
