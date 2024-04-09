package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import src.controller.Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameOverScreen {
    private int width;
    private int height;
    private Button restartButton;
    private Button closeButton;

    private int money;
    private double health;
    private int armyHealth;

    private Label moneyLabel;
    private Label healthLabel;
    private Label armyHealthLabel;

    private Image endScreenImage;

    private GameOverScreen() {

    }
    public GameOverScreen(int width, int height, Image endScreenImg, int moneyP, double healthP, int armyHealthP) {
        this.width = width;
        this.height = height;
        money = moneyP;
        health = healthP;
        armyHealth = armyHealthP;
        endScreenImage = endScreenImg;
        restartButton = new Button("Restart Game");
        closeButton = new Button("Quit Game");

        moneyLabel = new Label("Player Money Statistic: " + money);
        healthLabel = new Label("Player Health Statistic: " + health);
        armyHealthLabel = new Label("Enemy Army Health Statistic: " + armyHealth);

        moneyLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        moneyLabel.setTranslateY(-300);

        healthLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        healthLabel.setTranslateY(-250);

        armyHealthLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        armyHealthLabel.setTranslateY(-200);


        try {
            initGameOverScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Scene getScene() throws IOException {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, width, height);
        restartButton.setId("startgame");
        Image image = endScreenImage;
//        Image image = new Image(new FileInputStream("./assets/gameOver.png"));
        restartButton.setId("restartgame");
        closeButton.setId("quitgame");
        
        ImageView imageView1 = new ImageView(image);
        imageView1.setX(0);
        imageView1.setY(0);
        imageView1.setFitHeight(900);
        imageView1.setFitWidth(675);
        imageView1.setPreserveRatio(true);
        // Set root node
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 700, 650);
        rootNode.add(imageView1, 0, 0);

        // Create start button
        restartButton.setStyle("-fx-background-color: #B489FF; ");
        restartButton.setTranslateX(-100);
        restartButton.setTranslateY(170);

        // Close button will quit out of welcome screen window
        closeButton.setStyle("-fx-background-color: #89FFD2; ");
        closeButton.setTranslateX(100);
        closeButton.setTranslateY(170);

        // Adds buttons on top of welcome image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView1, restartButton, closeButton, moneyLabel, healthLabel, armyHealthLabel);
        rootNode.getChildren().add(stackPane);
        return myScene;
    }

    private void initGameOverScreen() throws IOException {
        FirstScreen screen = new FirstScreen(width, height);
        closeButton.setOnAction(e -> Controller.mainWindow.close());
        //Button playButton = screen.getPlayButton();
        restartButton.setOnAction(e -> {
            try {
                Controller.initFirstScreen();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });

        Scene scene = screen.getScene();
        Controller.mainWindow.setScene(scene);
        Controller.mainWindow.show();
    }

    public Button getQuitButton() {
        return closeButton;
    }

    public Button getPlayButton() {
        return restartButton;
    }
}
