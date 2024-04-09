package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.IOException;

public class FirstScreen {
    private int width;
    private int height;
    private Button startButton;
    private Button closeButton;

    private FirstScreen() {

    }
    public FirstScreen(int width, int height) {
        this.width = width;
        this.height = height;
        startButton = new Button("Start Game");
        closeButton = new Button("Quit Game");
    }
    public Scene getScene() throws IOException {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, width, height);
        startButton.setId("startgame");
        Image image = new Image(new FileInputStream("./assets/welcomep.png"));
        ImageView imageView1 = new ImageView(image);
        imageView1.setX(0);
        imageView1.setY(25);
        imageView1.setFitHeight(700);
        imageView1.setFitWidth(675);
        imageView1.setPreserveRatio(true);
        // Set root node
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 700, 650);
        rootNode.add(imageView1, 0, 0);

        // Create start button
        startButton.setStyle("-fx-background-color: #B489FF; ");
        startButton.setTranslateX(-100);
        startButton.setTranslateY(170);

        // Close button will quit out of welcome screen window
        closeButton.setStyle("-fx-background-color: #89FFD2; ");
        closeButton.setTranslateX(100);
        closeButton.setTranslateY(170);

        // Adds buttons on top of welcome image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView1, startButton, closeButton);
        rootNode.getChildren().add(stackPane);

        return myScene;
    }

    public Button getQuitButton() {
        return closeButton;
    }

    public Button getPlayButton() {
        return startButton;
    }
}
