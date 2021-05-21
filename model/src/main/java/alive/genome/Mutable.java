package alive.genome;

public interface Mutable<T> {

    T mutate(T original);
}
