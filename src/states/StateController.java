package states;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class StateController {

    public Logger logger = Logger.getLogger(StateController.class.getName());

    private Map<String, State> stateMap;
    private State currentState;

    public StateController() {
        stateMap = new HashMap<>();
    }

    public void addState(String name, State state) {
        if (name==null || name.isEmpty()) {
            logger.severe("State name cannot be empty");
            return;
        }

        if (state==null) {
            logger.severe("State cannot be null");
            return;
        }

        state.onCreate();
        this.stateMap.put(name, state);
    }


    public void setState(String stateName) {
        this.currentState = stateMap.get(stateName);
        if (this.currentState==null) {
            logger.warning("No valid state name provided");
        }
    }

    public void destroyState(String stateName) {
        State state = this.stateMap.get(stateName);
        state.onDestroy();
    }

    public void setCurrentState(String stateName) {
        currentState.onLeave();
        this.currentState = this.stateMap.get(stateName);
        currentState.onEnter();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
