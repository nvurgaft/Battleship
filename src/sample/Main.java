package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    private MenuBar menuBar;
    private Menu gameMenu, helpMenu;
    private MenuItem newGameMenuItem, exitMenuItem;
    private MenuItem aboutMenuItem;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
            alert.setHeaderText("This game is a port of the classic battleships game");
            alert.setContentText("This game was written for the JCE Game development course, spring 2016. Using Java FX GUI platform using Java 8");
            alert.showAndWait();
        });

        helpMenu.getItems().addAll(aboutMenuItem);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(gameMenu, helpMenu);

        VBox topContainer = new VBox();
        topContainer.getChildren().addAll(menuBar);
        BorderPane layout = new BorderPane();
        layout.setTop(topContainer);

        GameScene gameScene = new GameScene(layout, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);

        stage.setScene(gameScene);
        gameScene.start();
        stage.show();
    }
}
