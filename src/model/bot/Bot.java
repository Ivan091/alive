package model.bot;

import model.Field;
import model.bot.energy.Energy;
import model.bot.gen.IGen;
import model.bot.gen.direct_gen.Photosynthesis;
import model.bot.energy.IEnergy;

public class Bot implements IBotMakeAMove, IBotReplicateAndDie {

    public final Vector2Dint coordinates;

    private final IEnergy energy;

    private final IGen[] genome;

    private int currentGenIdx;

    private boolean isFinished;

    public Bot(int x, int y, int energy) {
        coordinates = new Vector2Dint(x, y);
        this.energy = new Energy(this, energy);

        /*
         * At the start each bot has photosynthesis genes only.
         */
        genome = new IGen[64];
        for (var i = 0; i < genome.length; ++i) {
            genome[i] = new Photosynthesis();
        }
    }

    @Override
    public void makeAMove(Field field) {

        while(!isFinished && genome[currentGenIdx].run(this, field)){

        }

    }
    /**
     * Changes currentGenIndex looped
     * @param addition added to currentGenIndex
     */
    public void addToCurrentGenIndexSave (int addition){
        currentGenIdx += addition;
        currentGenIdx %= genome.length;
    }

    @Override
    public void Replicate() {
    }

    @Override
    public void Die() {
        System.out.println("Bot is dead");
        this.isFinished = true;
    }

    public IEnergy getEnergy(){
        return energy;
    }
}
