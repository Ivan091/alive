package alive.config;

import alive.organic.Organic;
import alive.organic.cell.CellHealth;
import alive.organic.health.Health;
import alive.organic.health.HealthBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class HealthFactoryConfig implements HealthFactory {

    @Override
    @Scope("prototype")
    @Autowired(required = false)
    public Health createCellHealth(Integer initHealth, Organic owner) {
        return new CellHealth(new HealthBasic(initHealth), owner);
    }
}
