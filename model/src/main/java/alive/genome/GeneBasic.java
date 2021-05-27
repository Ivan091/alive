package alive.genome;

import org.springframework.stereotype.Component;


@Component
public abstract class GeneBasic implements Gene {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
