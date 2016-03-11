package states;

import javafx.scene.Node;

public abstract class State implements StateInterface {

    private String stateName = "Default state";
    protected StateController stateController;

    public State(StateController stateController) {
        this.stateController = stateController;
    }

    protected void onCreate(Node ui) { }

    protected void onEnter() { }

    protected void onLeave() { }

    protected void onDestroy() { }

    public void redirectToState(String stateName) {
        this.stateController.setCurrentState(stateName);
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return this.stateName;
    }

    @Override
    public void input() { }

    @Override
    public void render(Object graphic) { }

    @Override
    public void sound() { }

    @Override
    public void update() { }
}
