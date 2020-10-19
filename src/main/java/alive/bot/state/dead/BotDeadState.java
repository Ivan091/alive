package alive.bot.state.dead;

import alive.bot.state.State;

public class BotDeadState implements DeadState {

    @Override
    public State getState() {

        return this;
    }
}
