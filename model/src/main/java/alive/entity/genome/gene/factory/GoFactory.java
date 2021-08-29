package alive.entity.genome.gene.factory;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GoFactory implements Factory<Gene> {

    @Bean("go")
    @Override
    public Gene create() {
        return new Sequence(
                new Go(),
                new Heal(-510),
                new IndexJump(1),
                new ReAffect()
        );
    }
}
