package alive.entity.genome.gene.factory;

import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.IndexJump;
import alive.entity.genome.gene.command.Replicate;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Supplier;


@Configuration
public class ReplicateFactory implements Supplier<Gene> {

    @Bean("replicate")
    @Override
    public Gene get() {
        return new Sequence(
                new Replicate(),
                new IndexJump(1)
        );
    }
}
