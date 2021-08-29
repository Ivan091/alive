package alive.entity.genome.gene.factory;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.*;
import java.util.Random;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@Configuration
public class IndexJumpFactory implements Factory<Gene> {

    private final Random random = new Random();

    @Bean("indexJump")
    @Scope(SCOPE_PROTOTYPE)
    @Override
    public Gene create() {
        var key = random.nextInt(8) + 1;
        return new Sequence(
                new Heal(-key * 10),
                new IndexJump(key),
                new ReAffect()
        );
    }
}

