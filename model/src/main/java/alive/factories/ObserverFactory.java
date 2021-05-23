package alive.factories;

public interface ObserverFactory<T, O> {

    T create(O observedObj);
}
