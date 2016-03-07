package states;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

import java.util.logging.Logger;

public class StartScreen extends State {

    Logger logger = Logger.getLogger(StartScreen.class.getName());

    private String stateName = "StartScreen";

    Image titleImage;

    @Override
    public void onCreate(Node ui) {
        logger.info("StartScreen: onCreate");

        titleImage = new Image("file:assets/images/title.JPG");

        Button startButton = new Button("Start");
        startButton.setOnAction(event -> {
            logger.info("Click");
        });

        Group group = (Group) ui;
        group.getChildren().addAll(startButton);
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
    public void render(Object graphics) {
        GraphicsContext gc = (GraphicsContext) graphics;

        // set fill background
        gc.setFill(Color.ALICEBLUE);
        gc.fillRect(0, 0, 800, 600);

        // set title background picture
        gc.setGlobalAlpha(0.3);
        gc.drawImage(titleImage, 0, 0);
        gc.setGlobalAlpha(1);

        // title
        gc.setStroke(Color.DARKBLUE);
        gc.setFont(Font.font("Ariel", FontPosture.ITALIC, 92));
        gc.strokeText("Battleships", 100, 140);

        // sub title
        gc.setStroke(Color.BLUEVIOLET);
        gc.setFont(Font.font("Ariel", FontPosture.REGULAR, 24));
        gc.strokeText("and stuff and stuff ...", 160, 180);
    }

    @Override
    public void sound() {

    }

    @Override
    public void update() {

    }
}
