package alive.entity;

public interface Visitable {

    void accept(Visitor visitor);
}
