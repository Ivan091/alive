package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import alive.entity.genome.gene.wrapper.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PhotosynthesisFactory implements Factory<Gene> {

    @Bean("Photosynthesis")
    @Override
    public Gene create() {
        var heal = 250;
        return new Sequence(
                new Paint(c -> c.remix(-heal / 128, heal / 60, -heal / 128)),
                new Heal(heal),
                new Increment(1)
        );
    }
}
