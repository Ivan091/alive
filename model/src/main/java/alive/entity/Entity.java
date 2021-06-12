package alive.entity;

import java.awt.*;
import java.util.function.Function;


public interface Entity extends Visitable {

    void repaint(Function<Color, Color> modifier);

    Color color();

    void register();

    void unregister();
}
