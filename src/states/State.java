package states;

public interface State {

    public void onCreate();
    public void onEnter();
    public void onLeave();
    public void onDestroy();

    public void input();
    public void render();
    public void sound();
    public void update();

}
