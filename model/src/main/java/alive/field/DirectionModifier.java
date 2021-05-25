package alive.field;

public interface DirectionModifier {

    Position modify(Position position, int index);

    DirectionModifier reproduce();
}
