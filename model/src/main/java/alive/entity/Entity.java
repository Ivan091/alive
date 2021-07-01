package alive.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.function.UnaryOperator;


@JsonSerialize(as = Entity.class)
public interface Entity extends Visitable {

    void repaint(UnaryOperator<Color> modifier);

    @JsonProperty
    @JsonUnwrapped
    Color color();

    void register();

    void unregister();
}
