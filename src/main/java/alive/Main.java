package alive;

import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAliveAlive;
import alive.entities.alive.bot.genome.BotGenome;
import alive.entities.qualities.position.PositionEntity;
import alive.field.FieldLive;
import alive.field.SimulationLive;

public class Main {

    public static void main(String[] args) {
        var bot = new BotAlive(new FieldLive(10, 10), new PositionEntity(1, 1),
                new EnergyAliveAlive(100), new BotLookDirection(), BotGenome.createFirstBotGenome());
    }

    public static void start() {
        var simulation = new SimulationLive(new FieldLive(10, 10));
        simulation.start();
    }
}