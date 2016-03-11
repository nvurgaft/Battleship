package states;

import board.Board;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.logging.Logger;

public class GameSetupScreen extends State {

    public static Logger logger = Logger.getLogger(GameSetupScreen.class.getName());

    private String stateName = "GameSetupScreen";

    private Board board;

    public GameSetupScreen(StateController stateController) {
        super(stateController);
    }

    @Override
    protected void onCreate(Node ui) {
        logger.info("GameSetupScreen: onCreate");
        board = new Board();

        Group group = (Group) ui;

        group.getChildren().addAll(new Button("Done"));

        super.setStateName("Game setup");
    }

    @Override
    protected void onEnter() {
        logger.info("GameSetupScreen: onEnter");
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void render(Object graphics) {
        GraphicsContext gc = (GraphicsContext) graphics;

        gc.setFill(Color.ALICEBLUE);
        gc.fillRect(0, 0, 800, 600);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        for (int i=0; i<=10; i++) {
            for (int j=0; j<=10; j++) {
                gc.strokeLine(40 + i*40, 40, 40 + i*40, 440);
                gc.strokeLine(40, 40 + i*40, 440, 40 + i*40);
            }
        }

        gc.setFont(Font.font("Courier", 14));
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                gc.strokeText("A", 25, 20+(i+1)*40);
                gc.strokeText("1", 20+(i+1)*40, 25);
            }
        }
    }

    @Override
    public void sound() {
        super.sound();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    protected void onLeave() {
        super.onLeave();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public String getStateName() {
        return this.stateName;
    }
}
