package alive.alive.genome;

public interface Genome extends Gene {

    void incrementGeneIndex(int increment);

    Genome reproduce();
}
