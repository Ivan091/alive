package alive.entity;

import java.awt.*;
import java.util.function.Function;


public abstract class EntityBase implements Entity {

    private Color color;

    public EntityBase(Color color) {
        this.color = color;
    }

    @Override
    public void repaint(Function<Color, Color> modifier) {
        color = modifier.apply(color);
    }

    @Override
    public Color color() {
        return color;
    }
}
