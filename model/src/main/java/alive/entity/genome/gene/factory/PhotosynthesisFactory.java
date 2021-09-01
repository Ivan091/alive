package alive.entity.genome.gene.factory;

import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Supplier;


@Configuration
public class PhotosynthesisFactory implements Supplier<Gene> {

    @Bean("photosynthesis")
    @Override
    public Gene get() {
        var heal = 250;
        return new Sequence(
                new Paint(c -> c.remix(-heal / 128, heal / 60, -heal / 128)),
                new Heal(heal),
                new IndexJump(1)
        );
    }
}
