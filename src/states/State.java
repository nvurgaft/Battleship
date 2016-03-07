package states;

import javafx.scene.Node;

public class State implements StateInterface {

    private String stateName = "Default state";

    protected void onCreate(Node ui) { }

    protected void onEnter() { }

    protected void onLeave() { }

    protected void onDestroy() { }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return this.stateName;
    }

    @Override
    public void input() { }

    @Override
    public void render(Object graphic) {

    }

    @Override
    public void sound() { }

    @Override
    public void update() { }
}
