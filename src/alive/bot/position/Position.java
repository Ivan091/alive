package alive.bot.position;

import alive.Field;

import java.util.List;

public interface Position {

    int getX();

    int getY();

    List<BotPosition> getPositionsAround(Field field);
}
