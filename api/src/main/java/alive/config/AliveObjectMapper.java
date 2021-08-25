package alive.config;

import alive.entity.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class AliveObjectMapper extends ObjectMapper {

    public AliveObjectMapper(@Qualifier("jsonComponentModule") SimpleModule simpleModule, EntitySerializer entitySerializer) {
        simpleModule.addSerializer(Entity.class, entitySerializer);
        registerModule(simpleModule);
    }
}
