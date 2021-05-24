package alive.factories;

import alive.Entity;
import alive.field.Field;
import alive.field.matrix.FieldMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class FieldFactoryConfig implements FieldFactory {

    private final Entity entity;

    public FieldFactoryConfig(Entity entity) {
        this.entity = entity;
    }

    @Override
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Autowired(required = false)
    public Field create(int width, int height) {
        return new FieldMatrix(width, height, entity);
    }
}
