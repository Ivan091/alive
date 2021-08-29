package alive.entity.genome.gene.factory;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.IndexJump;
import alive.entity.genome.gene.command.Replicate;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ReplicateFactory implements Factory<Gene> {

    @Bean("replicate")
    @Override
    public Gene create() {
        return new Sequence(
                new Replicate(),
                new IndexJump(1)
        );
    }
}
