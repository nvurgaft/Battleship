package logic;

import states.State;
import states.StateController;

public class Game {

    StateController stateController;

    public Game() {
        stateController = new StateController();

        State startScreen = new State();
        String sName = startScreen.getStateName();
        stateController.addState(sName, startScreen);
    }
}
