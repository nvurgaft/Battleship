package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    private MenuBar menuBar;
    private Menu gameMenu, helpMenu;
    private MenuItem newGameMenuItem, exitMenuItem;
    private MenuItem aboutMenuItem;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Battleships");
        stage.setResizable(false);

        gameMenu = new Menu("Game");

        newGameMenuItem = new MenuItem("New game");
        exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText("Leaving so soon ?");
            alert.setContentText("This will ruin your game!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Platform.exit();
            }
        });

        gameMenu.getItems().addAll(newGameMenuItem, exitMenuItem);

        helpMenu = new Menu("Help");
        aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Battleships");
            alert.setContentText("This game was written with Java FX GUI platform using Java 8");
            alert.showAndWait();
        });

        helpMenu.getItems().addAll(aboutMenuItem);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(gameMenu, helpMenu);

        VBox topContainer = new VBox();
        topContainer.getChildren().addAll(menuBar);
        BorderPane layout = new BorderPane();
        layout.setTop(topContainer);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);

        GameScene gameScene = new GameScene(layout, WIDTH, HEIGHT);

        Group rootGroup = new Group();
        rootGroup.getChildren().addAll(canvas);
        layout.setCenter(rootGroup);
        stage.setScene(gameScene);
        gameScene.start();
        stage.show();
    }

        protected void draw(GraphicsContext gc) {
            gc.setFill(Color.ALICEBLUE);
            gc.fillRect(0, 0, WIDTH, HEIGHT);

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
}
