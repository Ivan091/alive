package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.*;
import java.util.Random;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


public record Rotate(int key) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.rotate(key);
    }

    @Configuration
    public static class GeneFactory implements Factory<Gene> {

        private final Random random = new Random();

        @Bean("Rotate")
        @Scope(SCOPE_PROTOTYPE)
        @Override
        public Gene create() {
            var key = random.nextInt(8) - 3;
            return new Sequence(
                    new Rotate(key),
                    new Heal(-key * 40),
                    new Increment(1),
                    new ReAffect()
            );
        }
    }
}
