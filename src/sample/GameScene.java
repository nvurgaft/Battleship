package sample;

import javafx.animation.AnimationTimer;
import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;
import states.State;
import states.StateController;


public class GameScene extends Scene {

    private StateController stateController;
    private State currentState;

    public GameScene(@NamedArg("root") Parent root, int width, int height) {
        super(root, width, height);
        stateController = new StateController();
        currentState = stateController.getCurrentState();
    }

    public StateController getStateController() {
        return stateController;
    }

    public void start() {

        new AnimationTimer() {

            long then = System.nanoTime();

            @Override
            public void handle(long now) {

                double fps = 1000000.0 / (then - now);

                currentState.input();
                currentState.sound();
                currentState.update();
                currentState.render();

                then = now;
            }
        }.start();
    }
}
