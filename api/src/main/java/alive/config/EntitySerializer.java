package alive.config;

import alive.entity.Entity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class EntitySerializer extends JsonSerializer<Entity> {

    @Override
    public void serialize(Entity entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        var c = entity.color();
        jsonGenerator.writeString(String.format("#%02X%02X%02X", c.r(), c.g(), c.b()));
    }
}
