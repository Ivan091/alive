package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.*;
import alive.entity.genome.Gene;
import alive.entity.genome.gene.command.*;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;
import java.util.function.Function;


@Component
public final class Eat implements Factory<Gene> {

    private final Gene gene = new GeneSequence(
            o -> o.look().ifPresent(other -> other.accept(
                    new HealthVisitor(
                            Entity::unregister,
                            organic -> {
                                var dHealth = organic.health();
                                new MoveSequence(
                                        new Heal(dHealth),
                                        new Paint(c -> c.remix(dHealth / 60, -dHealth / 128, -dHealth / 128))
                                ).affect(o);
                                organic.unregister();
                            },
                            o::isFriendly
                    ))),
            new Heal(-210),
            new IndexIncrement(1)
    );

    @Override
    public Gene create() {
        return gene;
    }

    private static record HealthVisitor(Consumer<Entity> ifEntity, Consumer<Organic> ifOrganic, Function<Alive, Boolean> ifAlive) implements Visitor {

        @Override
        public void visit(Entity entity) {
            ifEntity.accept(entity);
        }

        @Override
        public void visit(Organic organic) {
            ifOrganic.accept(organic);
        }

        @Override
        public void visit(Alive alive) {
            if (!ifAlive.apply(alive)) {
                visit((Organic) alive);
            }
        }
    }
}
