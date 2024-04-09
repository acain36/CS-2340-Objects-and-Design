package src.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import src.view.FirstScreen;
import src.view.SecondScreen;
import src.view.ThirdScreen;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Controller extends Application {
    public static Stage mainWindow;
    public static int width = 800;
    public static int height = 675;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setTitle("Sugar Siege");
        initFirstScreen();
    }

    public static void initFirstScreen() throws IOException {
        FirstScreen screen = new FirstScreen(width, height);
        Button quitButton = screen.getQuitButton();
        quitButton.setOnAction(e -> mainWindow.close());
        Button playButton = screen.getPlayButton();
        playButton.setOnAction(e -> {
            try {
                goToSecondScreen();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                Logger logger = Logger.getLogger(Controller.class.getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public static void goToSecondScreen() throws IOException {
        SecondScreen screen = new SecondScreen(width, height);
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        Button enterButton = screen.getEnterButton();
        enterButton.setOnAction(e -> {
            try {
                String difficulty = ((RadioButton) screen.getRadioButtons()
                        .getSelectedToggle()).getText();
                String level = ((RadioButton) screen.getRadioButtonsLevel()
                        .getSelectedToggle()).getText();
                String name = screen.getTextField().getText();
                if (name.isEmpty() || name.isBlank() || name == null) {
                    throw new RuntimeException();
                }
                goToThirdScreen(difficulty, name, level);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                Logger logger = Logger.getLogger(Controller.class.getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            } catch (RuntimeException r) {
                Alert alertBox = new Alert(Alert.AlertType.ERROR);
                alertBox.setTitle("Error");
                alertBox.setHeaderText("Invalid Input");
                alertBox.setContentText("Please enter a valid name");
                alertBox.showAndWait();
            }

        });
    }
    public static void goToThirdScreen(String difficulty, String name,
                                       String level) throws IOException {
        ThirdScreen screen = new ThirdScreen(width, height, difficulty, level, name, mainWindow);
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public Stage getMainWindow() {
        return mainWindow;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
