package alive.entity.genome.gene.factory;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EatFactory implements Factory<Gene> {

    @Bean("eat")
    @Override
    public Gene create() {
        return new Sequence(
                new Eat(),
                new Heal(-210),
                new IndexJump(1)
        );
    }
}
