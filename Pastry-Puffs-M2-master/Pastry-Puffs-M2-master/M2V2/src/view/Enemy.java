package src.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Enemy extends Pane {
    private String enemyName;
    private int enemyHealth;
    private Image enemyImage;
    private Label eName;
    private Label eHealthLabel;


    public Enemy(String name, int health) {
        enemyName = name;
        enemyHealth = health;
        eName = new Label(enemyName);

        this.setPrefSize(1000, 1000);
        this.setStyle("-fx-background-color: BLUE");
        eHealthLabel = new Label("Enemy Health: " + enemyHealth);
        try {
            initializeEnemyImage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initializeEnemyImage() throws FileNotFoundException {
        switch (enemyName) {
        case "name1":
            //sets image 1
            enemyImage = new Image(new FileInputStream("./assets/Enemy1.png"));
            break;
        case "name2":
            //sets image 2
            enemyImage = new Image(new FileInputStream("./assets/Enemy1.png"));
            break;
        case "name3":
            //sets image 3
            enemyImage = new Image(new FileInputStream("./assets/Enemy1.png"));
            break;
        default:
            //defaults to case1
            enemyImage = new Image(new FileInputStream("./assets/Enemy1.png"));
            break;
        }
    }

    public Image getEnemyImage() {
        return enemyImage;
    }

    public Label getName() {
        return eName;
    }
    public Label getHealthLabel() {
        return eHealthLabel;
    }

    public int getIntHealth() {
        return enemyHealth;
    }

    public void setIntHealth(int health) {
        enemyHealth = health;
        eHealthLabel.setText("Enemy Health " + enemyHealth);
    }
}
