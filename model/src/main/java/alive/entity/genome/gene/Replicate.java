package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import alive.entity.genome.gene.command.Increment;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public record Replicate() implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.replicate();
    }

    @Configuration
    public static class GeneFactory implements Factory<Gene> {

        @Bean("replicate")
        @Override
        public Gene create() {
            return new Sequence(
                    new Replicate(),
                    new Increment(1)
            );
        }
    }
}
