package alive.config;

import alive.Entity;
import alive.field.Field;
import alive.field.matrix.FieldMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class FieldFactoryConfig implements FieldFactory {

    private final Entity hollow;

    public FieldFactoryConfig(Entity hollow) {
        this.hollow = hollow;
    }

    @Override
    @Scope("prototype")
    @Autowired(required = false)
    public Field createFieldMatrix(int width, int height) {
        return new FieldMatrix(width, height, hollow);
    }
}
