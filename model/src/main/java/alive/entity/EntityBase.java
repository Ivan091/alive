package alive.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.awt.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;


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
