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
        jsonGenerator.writeString(entity.color().toHex());
    }
}
