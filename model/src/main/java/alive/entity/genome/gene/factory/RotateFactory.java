package alive.entity.genome.gene.factory;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.*;
import java.util.Random;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@Configuration
public class RotateFactory implements Factory<Gene> {

    private final Random random = new Random();

    @Bean("rotate")
    @Scope(SCOPE_PROTOTYPE)
    @Override
    public Gene create() {
        var key = random.nextInt(8) - 3;
        return new Sequence(
                new Rotate(key),
                new Heal(-key * 40),
                new IndexJump(1),
                new ReAffect()
        );
    }
}
