package alive.entity.genome;

import alive.common.CollectionUtils;
import alive.entity.Alive;


public final class SequentialGenome implements Genome {

    private final Gene[] genes;

    private final Mutator<Gene[]> genomeMutator;

    private final int healthIncrementDefault = -20;

    private int healthIncrement = healthIncrementDefault;

    private int currentGeneIdx;

    public SequentialGenome(Gene[] genes, Mutator<Gene[]> genomeMutator) {
        this.genes = genes;
        this.genomeMutator = genomeMutator;
    }

    @Override
    public Genome replicate() {
        return new SequentialGenome(genomeMutator.mutate(genes), genomeMutator);
    }

    @Override
    public void affect(Alive alive) {
        alive.heal(healthIncrement);
        if (alive.isRegistered()) {
            healthIncrement *= 3;
            genes[currentGeneIdx].affect(alive, this);
        }
        healthIncrement = healthIncrementDefault;
    }

    @Override
    public void incrementGeneIndex(int increment) {
        currentGeneIdx = CollectionUtils.makeLoopedInside(currentGeneIdx + increment, genes);
    }

    @Override
    public boolean isFriendly(Genome genome) {
        if (genome instanceof SequentialGenome other) {
            var diffs = 0;
            for (var i = 0; i < genes.length; i++) {
                if (!genes[i].equals(other.genes[i])) {
                    diffs++;
                    if (diffs >= genes.length / 10) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
