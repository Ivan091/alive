package alive.bot.position;

import java.util.List;

public interface Position {

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    List<Position> getPositionsAround();
}
