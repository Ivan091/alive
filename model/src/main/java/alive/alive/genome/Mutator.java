package alive.alive.genome;

public interface Mutator<T> {

    T mutate(T original);
}
