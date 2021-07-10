package alive.entity;

import java.util.function.UnaryOperator;


public abstract class EntityBase implements Entity {

    private Color color;

    public EntityBase(Color color) {
        this.color = color;
    }

    @Override
    public void repaint(UnaryOperator<Color> modifier) {
        color = modifier.apply(color);
    }

    @Override
    public Color color() {
        return color;
    }
}
