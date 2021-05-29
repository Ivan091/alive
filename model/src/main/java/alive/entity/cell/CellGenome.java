package alive.entity.cell;

import alive.entity.Alive;
import alive.genome.Gene;
import alive.genome.Genome;


public final class CellGenome implements Genome {

    private final Gene[] genes;

    private int currentGeneIdx;

    public CellGenome(Gene[] genes) {
        this.genes = genes;
    }

    @Override
    public Genome replicate() {
        return this;
    }

    @Override
    public void affect(Alive alive) {
        alive.heal(-5);
        if (alive.isMoving()) {
            genes[currentGeneIdx].affect(alive, this);
        }
    }

    @Override
    public void incrementGeneIndex(int increment) {
        currentGeneIdx = Math.floorMod(currentGeneIdx + increment, genes.length);
    }
}
