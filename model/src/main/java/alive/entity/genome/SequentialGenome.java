package alive.entity.genome;

import alive.entity.Alive;
import org.springframework.stereotype.Component;


public final class SequentialGenome implements Genome {

    private final Gene[] genes;

    private int currentGeneIdx;

    public SequentialGenome(Gene[] genes) {
        this.genes = genes;
    }

    @Override
    public Genome replicate() {
        return new SequentialGenome(MutatorProvider.mutator.mutate(genes));
    }

    @Override
    public void affect(Alive alive) {
        alive.heal(-5);
        if (!alive.isStatic()) {
            genes[currentGeneIdx].affect(alive, this);
        }
    }

    @Override
    public void incrementGeneIndex(int increment) {
        currentGeneIdx = Math.floorMod(currentGeneIdx + increment, genes.length);
    }

    @Component
    public static class MutatorProvider {

        private static Mutator<Gene[]> mutator;

        public MutatorProvider(Mutator<Gene[]> mutator) {
            MutatorProvider.mutator = mutator;
        }
    }
}
