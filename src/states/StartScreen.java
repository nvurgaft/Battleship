package states;

import java.util.logging.Logger;

public class StartScreen extends State {

    Logger logger = Logger.getLogger(StartScreen.class.getName());

    private String stateName = "StartScreen";

    @Override
    public void onCreate() {
        logger.info("StartScreen: onCreate");
    }

    @Override
    public void onEnter() {
        logger.info("StartScreen: onEnter");
    }

    @Override
    public void onLeave() {
        logger.info("StartScreen: onLeave");
    }

    @Override
    public void onDestroy() {
        logger.info("StartScreen: onDestroy");
    }

    @Override
    public String getStateName() {
        return super.getStateName();
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
