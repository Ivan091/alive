package alive.entity.genome.gene.factory;

import alive.common.CollectionUtils;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@Configuration
public class IndexJumpFactory implements Supplier<Gene> {

    private final Gene[] possibleGenes = IntStream.range(1, 8).mapToObj(this::buildGenes).toArray(Gene[]::new);

    @Bean("indexJump")
    @Scope(SCOPE_PROTOTYPE)
    @Override
    public Gene get() {
        return CollectionUtils.getRandom(possibleGenes);
    }

    private Gene buildGenes(int key) {
        return new Sequence(
                new Heal(-key * 10),
                new IndexJump(key),
                new ReAffect()
        );
    }
}

