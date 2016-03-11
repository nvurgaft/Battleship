package sample;

import javafx.animation.AnimationTimer;
import javafx.beans.NamedArg;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import states.State;
import states.StateController;

import java.util.logging.Logger;

public class GameScene extends Scene {

    public static Logger logger = Logger.getLogger(GameScene.class.getName());

    private StateController stateController;
    private State currentState;
    private Group uiGroup;
    private GraphicsContext gc;
    private Canvas canvas;

    public GameScene(@NamedArg("root") Parent root, int width, int height) {
        super(root, width, height);

        // stick the canvas to the scene layout
        uiGroup = new Group();
        canvas = new Canvas(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        uiGroup.getChildren().addAll(canvas);
        BorderPane pane = (BorderPane) root;
        pane.setCenter(uiGroup);

        stateController = new StateController(uiGroup);
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
                currentState = stateController.getCurrentState();
                double fps = 1000000.0 / (now - then);
                //logger.info("PFS: " + fps);

                currentState.input();
                currentState.sound();
                currentState.update();
                currentState.render(gc);

                then = now;
            }
        }.start();
    }


}
