package alive.entity;

public interface Entity extends Visitable {

    void makeAMoveIfAlive();

    boolean isAlive();
}
