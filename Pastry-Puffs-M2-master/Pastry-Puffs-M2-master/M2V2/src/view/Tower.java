package src.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Tower extends Pane {
    private String towerName;
    private String towerDescription;
    private int towerPrice;
    private Image towerImage;
    private Label tName;
    private Label tPrice;
    private Label tDescription;
    private Label damageLabel;

    private int damage;

    private double xTower = 0;
    private double yTower = 0;

    public Tower(String name, int price, String description) {
        towerName = name;
        towerDescription = description;
        towerPrice = price;
        tName = new Label(towerName);
        tDescription = new Label(towerDescription);
        damageLabel = new Label("Tower Damage: " + damage);
        this.setPrefSize(1000, 1000);
        this.setStyle("-fx-background-color: BLUE");
        tPrice = new Label("" + towerPrice);
        try {
            initializeTowerImage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.setOnMouseDragged(e -> {
            System.out.println("Register dragging");
            this.setLayoutX(this.getLayoutX() + e.getX());
            this.setLayoutY(this.getLayoutY() + e.getY());
        });
    }

    private void initializeTowerImage() throws FileNotFoundException {
        switch (towerName) {
        case "Peppermint Tower":
            //sets image 1
            towerImage = new Image(new FileInputStream("./assets/PepperMintTower.png"));
            damage = 10;
            damageLabel.setText("Tower Damage: " + damage);
            break;
        case "Icing Shoot":
            //sets image 2
            towerImage = new Image(new FileInputStream("./assets/tower2.png"));
            damage = 20;
            damageLabel.setText("Tower Damage: " + damage);
            break;
        case "Puff House":
            //sets image 3
            towerImage = new Image(new FileInputStream("./assets/tower3-1.png"));
            damage = 30;
            damageLabel.setText("Tower Damage: " + damage);
            break;
        default:
            //defaults to case1
            towerImage = new Image(new FileInputStream("./assets/PepperMintTower.png"));
            damage = 10;
            damageLabel.setText("Tower Damage: " + damage);
            break;
        }
    }

    public Image getTowerImage() {
        return towerImage;
    }

    public Label getName() {
        return tName;
    }
    public Label getDescription() {
        return tDescription;
    }
    public Label getPrice() {
        return tPrice;
    }

    public Label getDamageLabel() {
        return damageLabel;
    }

    public int getIntPrice() {
        return towerPrice;
    }

    public void setPrice(int price) {
        towerPrice = price;
        tPrice.setText("" + towerPrice);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damageUpgrade) {
        damage = damageUpgrade;
        damageLabel.setText("Upgraded Damage: " + damage);
    }

    public double getXTower() {
        return xTower;
    }
    public double getYTower() {
        return yTower;
    }
    public void setXTower(double x) {
        xTower = x;
    }
    public void setYTower(double y) {
        yTower = y;
    }
}
