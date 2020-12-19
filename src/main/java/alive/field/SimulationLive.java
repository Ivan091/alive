package alive.field;

import alive.entities.Entity;
import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAliveBot;
import alive.entities.alive.bot.genome.BotGenome;
import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.qualities.position.PositionEntity;

import java.util.HashMap;
import java.util.List;

public class SimulationLive implements Simulation {

    private final Field field;

    public SimulationLive(Field field) {
        this.field = field;
    }

    public void start() {

        field.putEntity(new BotAlive(field, new PositionEntity(0, 0),
                new EnergyAliveBot(500), new BotLookDirection(), BotGenome.createFirstBotGenome()));

        for (var i = 0; i < Integer.MAX_VALUE; ++i) {

            field.update();

            if (i % 1 == 0) {
                System.out.println('\n');
                createGenesReport();
                System.out.println('\n');
                createFieldReport();
                System.out.println('\n');
            }

            if (field.aliveCount() == 0) {

                System.out.println("\nThe population is dead(((");
                return;
            }
        }
    }

    private void createGenesReport() {

        var map = new HashMap<Class<? extends Gene>, Integer>();

        try {
            var aliveEntities = field.getClass().getDeclaredField("aliveEntities");
            aliveEntities.setAccessible(true);
            for (var alive : (List<Entity>) aliveEntities.get(field)) {
                var bot = (Bot) alive;
                var genome = bot.getGenome();

                var f = genome.getClass().getDeclaredField("genes");
                f.setAccessible(true);

                var genes = (Gene[]) f.get(genome);

                for (var gene : genes) {
                    map.merge(gene.getClass(), 1, Integer::sum);
                }
            }
        } catch (Exception ignored) {
        }

        map.forEach((x, y) -> System.out.format("%-9s%s", y.toString(), x.getSimpleName() + '\n'));
    }

    private void createFieldReport() {
        var map = new HashMap<Class<? extends Entity>, Integer>();
        for (var i = 0; i < field.getHeight(); ++i) {
            for (var j = 0; j < field.getWidth(); ++j) {
                var pos = new PositionEntity(i, j);
                map.merge(field.getCellsMatrix().getEntity(pos).getClass(), 1, Integer::sum);
            }
        }

        map.forEach((x, y) -> System.out.format("%-9s%s", y.toString(), x.getSimpleName() + '\n'));
    }
}
