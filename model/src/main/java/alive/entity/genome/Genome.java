package alive.entity.genome;

public interface Genome extends Move {

    Genome replicate();

    void incrementGeneIndex(int increment);

    boolean isFriendly(Genome genome);
}
