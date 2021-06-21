package alive.entity.genome;

public interface Mutator<T> {

    T mutate(T mutated);
}
