package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SecondScreen {
    private int width;
    private int height;
    private Button startGameButton;
    private String name;
    private String difficulty;
    private TextField getName;
    private ToggleGroup group;
    private ToggleGroup group2Level;


    private String level;

    private SecondScreen() {

    }
    public SecondScreen(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Scene getScene() throws IOException {
        //Get name and difficulty level
        Label askName = new Label("Name: ");
        getName = new TextField();
        HBox nameBox = new HBox(askName, getName);
        nameBox.setSpacing(20.0);

        Label chooseDifficulty = new Label("Difficulty: ");
        group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("easy");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("medium");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("hard");
        rb3.setToggleGroup(group);

        rb1.setId("easy");
        getName.setId("username");
        rb2.setId("medium");
        rb3.setId("hard");

        difficulty = ((RadioButton) group.getSelectedToggle()).getText();


        VBox difficultyBox = new VBox(chooseDifficulty, rb1, rb2, rb3);
        difficultyBox.setSpacing(20.0);


        Label chooseLevel = new Label("Level: ");
        group2Level = new ToggleGroup();
        RadioButton rbLevel1 = new RadioButton("Level 1");
        rbLevel1.setToggleGroup(group2Level);
        rbLevel1.setId("level1");
        rbLevel1.setSelected(true);
        RadioButton rbLevel2 = new RadioButton("Level 2");
        rbLevel2.setToggleGroup(group2Level);
        rbLevel2.setId("level2");
        RadioButton rbLevel3 = new RadioButton("Level 3");
        rbLevel3.setToggleGroup(group2Level);
        rbLevel3.setId("level3");

        level = ((RadioButton) group2Level.getSelectedToggle()).getText();
        System.out.println("SECOND SCREEN LEVEL" + level);

        VBox levelBox = new VBox(chooseLevel, rbLevel1, rbLevel2, rbLevel3);
        levelBox.setSpacing(20.0);


        //Create and Place EnterGameButton
        startGameButton = new Button("Enter Game");
        startGameButton.setStyle("-fx-background-color: #B489FF; ");
        startGameButton.setTranslateX(200);
        startGameButton.setTranslateY(200);
        startGameButton.setId("entergame");


        // Set root node
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(100));
        rootNode.setAlignment(Pos.TOP_LEFT);
        rootNode.addRow(0, nameBox);
        rootNode.addRow(1, difficultyBox);
        rootNode.addRow(2, levelBox);
        rootNode.setVgap(25);
        Scene myScene = new Scene(rootNode, 700, 650);

        rootNode.getChildren().add(startGameButton);
        return myScene;
    }
    public Button getEnterButton() {
        return startGameButton;
    }

    public TextField getTextField() {
        return getName;
    }

    public ToggleGroup getRadioButtons() {
        return group;
    }

    public ToggleGroup getRadioButtonsLevel() {
        return group2Level;
    }


}
