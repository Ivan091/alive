package alive.field;

public interface DirectionInspector {

    Position inspect(Position CurrentPosition);

    void rotate(int steps);

    DirectionInspector reproduce();
}
