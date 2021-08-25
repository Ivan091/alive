package alive.entity.genome;

import alive.entity.Alive;
import org.springframework.stereotype.Component;


public final class SequentialGenome implements Genome {

    private final Gene[] genes;

    private int healthIncrement = -2;

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
        alive.heal(healthIncrement);
        if (alive.isRegistered()) {
            healthIncrement *= 3;
            genes[currentGeneIdx].affect(alive, this);
        }
        healthIncrement = -2;
    }

    @Override
    public void incrementGeneIndex(int increment) {
        currentGeneIdx = Math.floorMod(currentGeneIdx + increment, genes.length);
    }

    @Override
    public boolean isFriendly(Genome genome) {
        if (genome instanceof SequentialGenome other) {
            var diffs = 0;
            for (var i = 0; i < genes.length; i++) {
                if (!genes[i].equals(other.genes[i])) {
                    diffs++;
                }
            }
            return diffs < genes.length / 4;
        }
        return false;
    }

    @Component
    public static class MutatorProvider {

        private static Mutator<Gene[]> mutator;

        public MutatorProvider(Mutator<Gene[]> mutator) {
            MutatorProvider.mutator = mutator;
        }
    }
}
