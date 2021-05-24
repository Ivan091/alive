package alive;

public interface Observer<T> {

    void subscribe(T observed);
}
