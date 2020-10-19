package alive.bot.position;

import alive.field.Field;

import java.util.List;

public interface Position {

    int getX();

    int getY();

    List<Position> getPositionsAround(Field field);
}
