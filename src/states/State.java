package states;

public class State implements StateInterface {

    private String stateName = "Default state";

    protected void onCreate() {

    }

    protected void onEnter() {

    }

    protected void onLeave() {

    }

    protected void onDestroy() {

    }

    public  String getStateName() {
        return this.stateName;
    }

    @Override
    public void input() {

    }

    @Override
    public void render() {

    }

    @Override
    public void sound() {

    }

    @Override
    public void update() {

    }
}
