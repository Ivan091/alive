package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public record Go() implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.goAhead();
    }

    @Configuration
    public static class GeneFactory implements Factory<Gene> {

        @Bean("Go")
        @Override
        public Gene create() {
            return new Sequence(
                    new Go(),
                    new Heal(-510),
                    new Increment(1),
                    new ReAffect()
            );
        }
    }
}
