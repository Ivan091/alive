package alive.alive.cell;

import alive.alive.Alive;
import alive.alive.genome.Gene;
import alive.alive.genome.Genome;


public class CellGenome implements Genome {

    private final Gene[] genes;

    private int currentGeneIndex;

    public CellGenome(Gene[] genes) {
        this(genes, 0);
    }

    public CellGenome(Gene[] genes, int currentGeneIndex) {
        this.genes = genes;
        this.currentGeneIndex = currentGeneIndex;
    }

    @Override
    public Genome reproduce() {
        return new CellGenome(genes);
    }

    @Override
    public void affect(Alive alive, Genome genome) {
        genes[currentGeneIndex].affect(alive, genome);
    }

    @Override
    public void incrementGeneIndex(int increment) {
        currentGeneIndex += increment;
        currentGeneIndex %= genes.length;
        if (currentGeneIndex < 0) {
            currentGeneIndex += genes.length;
        }
    }
}
