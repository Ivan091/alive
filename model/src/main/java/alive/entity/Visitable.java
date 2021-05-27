package alive.entity;

public interface Visitable {

    private void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
