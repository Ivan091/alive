package alive.entity.genome.gene.factory;

import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Supplier;


@Configuration
public class EatFactory implements Supplier<Gene> {

    @Bean("eat")
    @Override
    public Gene get() {
        return new Sequence(
                new Eat(),
                new Heal(-210),
                new IndexJump(1)
        );
    }
}
