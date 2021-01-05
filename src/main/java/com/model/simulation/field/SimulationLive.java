package com.model.simulation.field;

import com.model.simulation.entities.Entity;
import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.BotAlive;
import com.model.simulation.entities.alive.bot.direction.BotLookDirection;
import com.model.simulation.entities.alive.bot.energy.EnergyAliveAlive;
import com.model.simulation.entities.alive.bot.genome.BotGenome;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;
import com.model.simulation.entities.lifeless.LifelessBotBody;
import com.model.simulation.entities.qualities.position.PositionEntity;

import java.util.HashMap;
import java.util.List;


public class SimulationLive implements Simulation {

    private final Field field;

    public SimulationLive(Field field) {
        this.field = field;
    }

    public void start() {

        field.putEntity(new BotAlive(field, new PositionEntity(0, 0),
                new EnergyAliveAlive(500), new BotLookDirection(2), BotGenome.createFirstBotGenome()));
    }

    @Override
    public void nextMove() {
        field.update();
    }

    @Override
    public String currentCondition() {
        var sb = new StringBuilder();
        for (var j = field.getHeight() - 1; j > -1; --j) {
            for (var i = 0; i < field.getWidth(); ++i) {
                var pos = new PositionEntity(i, j);
                var entity = field.getCellsMatrix().get(pos);
                if (entity instanceof Bot) {
                    sb.append('b');
                } else if (entity instanceof LifelessBotBody) {
                    sb.append('=');
                } else {
                    sb.append('#');
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void createFieldReport() {


        var map = new HashMap<Class<? extends Entity>, Integer>();
        for (var i = 0; i < field.getHeight(); ++i) {
            for (var j = 0; j < field.getWidth(); ++j) {
                var pos = new PositionEntity(i, j);
                map.merge(field.getCellsMatrix().get(pos).getClass(), 1, Integer::sum);
            }
        }

        map.forEach((x, y) -> System.out.format("%-9s%s", y.toString(), x.getSimpleName() + '\n'));
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
}
