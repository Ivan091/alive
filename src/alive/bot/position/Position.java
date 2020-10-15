package alive.bot.position;

import alive.Field;

import java.util.List;

public interface Position {

    List<BotPosition> getPositionsAround(Field field);
}
