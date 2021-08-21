package alive.entity;

import java.util.function.UnaryOperator;


public interface Entity extends Visitable {

    void repaint(UnaryOperator<Color> modifier);

    Color color();

    void register();

    void unregister();
}
