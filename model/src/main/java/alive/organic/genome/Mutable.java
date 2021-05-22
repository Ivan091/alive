package alive.organic.genome;

public interface Mutable<T> {

    T mutate(T original);
}
