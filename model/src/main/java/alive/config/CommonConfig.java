package alive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Random;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@Configuration
public class CommonConfig {

    @Bean(SCOPE_PROTOTYPE)
    public Random random() {
        return new Random();
    }
}
