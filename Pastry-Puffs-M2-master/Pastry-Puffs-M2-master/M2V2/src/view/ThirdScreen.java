package src.view;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThirdScreen {
    private int width;
    private int height;
    private Button playerConfigButton;
    private Label healthStatus;
    private Label moneyStatus;
    private Label nameLabel;
    private double health;
    private int money;
    private String difficulty;
    private String level;

    private HBox towerMenu;
    private Rectangle area1;
    private StackPane stackPaneAboveMap;
    private GridPane gameArea;
    private Stage mainWindow;
    private int numCycles;

    private ArrayList<Tower> towersPlaced = new ArrayList<Tower>();

    public ThirdScreen(int width, int height, String diff,
                       String levelPar, String name, Stage mainWindow) {

        this.mainWindow = mainWindow;
        this.width = width;
        this.height = height;
        difficulty = diff;
        level = levelPar;

        initializeGameAttributes();

        healthStatus = new Label("Health is " + health + "%");
        healthStatus.setStyle("-fx-font-weight: bold");
        moneyStatus = new Label("Money is " + money + " coins");
        moneyStatus.setStyle("-fx-font-weight: bold");
        nameLabel = new Label("Name: " + name);
        nameLabel.setStyle("-fx-font-weight: bold");
    }

    public Scene getScene() throws IOException {
        VBox vbox = new VBox();

        // Set initial map image
        Image mapImage = new Image(new FileInputStream("./assets/EmptyGameBackground.png"));
        ImageView imageView1 = new ImageView(mapImage);
        imageView1.setX(0);
        imageView1.setY(25);
        imageView1.setTranslateY(50);
        imageView1.setFitHeight(700);
        imageView1.setFitWidth(675);
        imageView1.setPreserveRatio(true);
        imageView1.setId("Game map");

        // Set Root Node
        VBox rootNode = new VBox();
        //GridPane rootNode = new GridPane(); -old root
        rootNode.setPadding(new Insets(15));
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, width, height);

        // Player position labels
        nameLabel.setTranslateX(-240);
        nameLabel.setTranslateY(-180);
        healthStatus.setTranslateX(-240);
        healthStatus.setTranslateY(-160);
        moneyStatus.setTranslateX(-240);
        moneyStatus.setTranslateY(-140);
        // Color coordinating player information labels
        nameLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        nameLabel.setTextFill(Color.ORANGE);
        healthStatus.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        healthStatus.setTextFill(Color.HOTPINK);
        moneyStatus.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        moneyStatus.setTextFill(Color.LIGHTSKYBLUE);


        stackPaneAboveMap = new StackPane();
        stackPaneAboveMap.setTranslateY(100);
        stackPaneAboveMap.getChildren().addAll(healthStatus, moneyStatus, nameLabel, towerMenu);


        gameArea = new GridPane();
        gameArea.getChildren().add(imageView1);

        enemyActivate2();

        rootNode.getChildren().addAll(stackPaneAboveMap, gameArea);
        return scene;
    }

    private void initializeGameAttributes() {
        switch (difficulty) {
        case "medium":
            health = 85.0;
            money = 85;
            numCycles = 4;
            initializeTowerMenu();
            break;
        case "hard":
            health = 70.0;
            money = 70;
            numCycles = 5;
            initializeTowerMenu();
            break; //initializes health, money, and tower menu
        case "easy":
        default:
            health = 100.0;
            money = 100;
            numCycles = 2;
            initializeTowerMenu();
        }
    }



    private ImageView initializeEnemyImg(Enemy e1) {
        ImageView imageViewE1 = new ImageView(e1.getEnemyImage());
        imageViewE1.setId("imageViewE1");
        imageViewE1.setFitHeight(50);
        imageViewE1.setFitWidth(50);
        return imageViewE1;
    }


    private void enemyActivate2() throws FileNotFoundException {

        // design for enemy button
        Button startEnemyButton = new Button("Activate Enemies");
        startEnemyButton.setId("activateEnemiesButton");
        startEnemyButton.setTranslateX(300.0);
        startEnemyButton.setTranslateY(-230.0);
        startEnemyButton.setStyle("-fx-background-color: #FF503E; ");
        Enemy enemy1;

        Enemy finalBoss = new Enemy("name1", 70);

        switch (level) {
        case "Level 2":
            enemy1 = new Enemy("name1", 150);
            break;
        case "Level 3":
            enemy1 = new Enemy("name1", 250);
            break; //changes price of tower based on difficulty set
        case "Level 1":
        default:
            enemy1 = new Enemy("name1", 100);
        }

        Label eHealthLabel1 = enemy1.getHealthLabel();

        Label finalBossHealthLabel = finalBoss.getHealthLabel();
        finalBossHealthLabel.setText("Final Boss Health: " + finalBoss.getIntHealth());


        // ENEMY1 ARMY LABEL TO SCREEN
        eHealthLabel1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        eHealthLabel1.setTranslateY(-200);
        gameArea.getChildren().add(eHealthLabel1);
        gameArea.getChildren().add(startEnemyButton);


        // FINAL BOSS LABEL TO SCREEN
        finalBossHealthLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        finalBossHealthLabel.setTranslateX(200);
        finalBossHealthLabel.setTranslateY(-200);



        // if button pushed, call initializeEnemyImg certain # times
        startEnemyButton.setOnMouseClicked(e -> {
            // m6 bonus
//            Random random = new Random();
//            int randomNum = random.nextInt(100);
//            int randomLevel = randomNum % 3;
//
//            System.out.println("RANDOM LEVEL " + randomLevel);
//
//            System.out.println("Button activate pressed");

            gameArea.getChildren().add(finalBossHealthLabel);

            multipleEnemyTrans(enemy1, finalBoss);

        });
    }

    private void multipleEnemyTrans(Enemy enemy1, Enemy finalBossParameter) {

        System.out.println("PRINT LEVEL " + level);

        ParallelTransition p1 = testingTransitions(0, 210, 100, 210, numCycles);
        ParallelTransition p2 = testingTransitions(100, 210, 100, -85, numCycles);
        ParallelTransition p3 = testingTransitions(100, -85, 600, -85, numCycles);
        ParallelTransition p4 = testingTransitions(600, -85, 600, 120, numCycles);
        ParallelTransition p5 = testingTransitions(600, 120, 300, 120, numCycles);
        ParallelTransition p6 = testingTransitions(300, 120, 300, 250, numCycles);
        ParallelTransition p7 = testingTransitions(300, 250, 500, 250, numCycles);

        AtomicBoolean winOnly = new AtomicBoolean(false);

        Task<Void> combatTask = new Task<Void>() {
            @Override public Void call() throws InterruptedException {
                System.out.println("entered task pressed");
                p1.play();
                Platform.runLater(() -> {
                    System.out.println("Enemy 1 will be checked here");
                    int newHealth = checkTowerInRange(0, 210, enemy1, 100);
                });
                Thread.sleep(1000);
                p2.play();
                Platform.runLater(() -> {
                    System.out.println("Enemy 2 will be checked here");
                    int newHealth = checkTowerInRange(100, 210, enemy1, 100);
                });
                Thread.sleep(1000);
                p3.play();
                Platform.runLater(() -> {
                    try {
                        displayMoneyButton(300, 0);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enemy 3 will be checked here");
                    int newHealth = checkTowerInRange(100, -85, enemy1, 100);

                });
                Thread.sleep(1400);
                p4.play();
                Platform.runLater(() -> {
                    System.out.println("Enemy 4 will be checked here");
                    int newHealth = checkTowerInRange(600, -85, enemy1, 100);
                    finalBossMovementTransitions();
                    int finalBossNewHealth = checkTowerInRange(600, -85, finalBossParameter, 150);
                    Label finalBossHealthLabel = finalBossParameter.getHealthLabel();
                    finalBossHealthLabel.setText("Final Boss Health: " + finalBossNewHealth);
                });
                Thread.sleep(1500);
                p5.play();
                Platform.runLater(() -> {
                    System.out.println("Enemy 5 will be checked here");
                    int newHealth = checkTowerInRange(600, 120, enemy1, 100);
                    int finalBossNewHealth = checkTowerInRange(600, 120, finalBossParameter, 150);

                });
                Thread.sleep(1600);
                p6.play();
                Platform.runLater(() -> {
                    try {
                        displayMoneyButton(11, -150);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enemy 6 will be checked here");
                    int newHealth = checkTowerInRange(300, 120, enemy1, 100);
                    int finalBossNewHealth = checkTowerInRange(300, 120, finalBossParameter, 150);
                    Label finalBossHealthLabel = finalBossParameter.getHealthLabel();
                    finalBossHealthLabel.setText("Final Boss Health: " + finalBossNewHealth);
                    if (finalBossNewHealth <= 0) {
                        try {
                            winOnly.set(true);
                            Image image = new Image(new FileInputStream("./assets/wingamescreen.jpg"));
                            int enemyArmyHealth = enemy1.getIntHealth();
                            goToEndScreen(width, height, image, money, health, enemyArmyHealth);
                        } catch (Exception x) {
                            x.printStackTrace();
                            Logger logger = Logger.getLogger(getClass().getName());
                            logger.log(Level.SEVERE, "Failed to create new Window.", x);
                        }
                    }

                });
                Thread.sleep(1700);
                p7.setOnFinished(e -> {
                    try {
                        if (!winOnly.get()) {
                            Image image = new Image(new FileInputStream("./assets/gameOver.png"));
                            int enemyArmyHealth = enemy1.getIntHealth();
                            goToEndScreen(width, height, image, money, health, enemyArmyHealth);
                        }
                    } catch (Exception x) {
                        x.printStackTrace();
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", x);
                    }
                });
                p7.play();
                Platform.runLater(() -> {
                    System.out.println("Enemy 7 will be checked here");
                    int newEHealth = checkTowerInRange(300, 250, enemy1, 100);
                    if (newEHealth > 0) {
                        double indDamage = health / numCycles;
                        for (int i = 0; i < numCycles; i++) {
                            health = health - indDamage;
                            System.out.println("NEW HEALTH OF PLAYER " + health);
                            healthStatus.setText("Health is " + health + "%");
                        }
                    }
                });
                Thread.sleep(1700);
                return null;
            }
        };
        Thread getItemsThread = new Thread(combatTask);
        getItemsThread.setDaemon(true);
        getItemsThread.start();
    }

    private int checkTowerInRange(int x, int y, Enemy enemy1, int range) {
        int newHealthInt = enemy1.getIntHealth();
        System.out.println("towers places arraylist size " + towersPlaced.size());
        for (int i = 0; i < towersPlaced.size(); i++) {
            Tower tPlaced = towersPlaced.get(i);
            System.out.println("TOWER PLACED CURRENT NAME: " + tPlaced.getName());
            if (Math.abs(tPlaced.getXTower() - x) <= range
                    || Math.abs(tPlaced.getYTower() - y) <= range) {
                System.out.println("checked tower placement x");
                newHealthInt = enemy1.getIntHealth() - tPlaced.getDamage();
                System.out.println("og health " + enemy1.getIntHealth());
                if (newHealthInt < 0) {
                    newHealthInt = 0;
                }
                enemy1.setIntHealth(newHealthInt);
                System.out.println("decreased health " + newHealthInt);
            }
        }
        return newHealthInt;
    }

    private ParallelTransition testingTransitions(int oldX, int oldY,
                                                  int newX, int newY, int cycleCount) {
        Rectangle rectParallel = new Rectangle(10, 200, 50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.DARKBLUE);
        rectParallel.setTranslateX(50);
        rectParallel.setTranslateY(75);

        switch (level) {
        case "Level 2":
            System.out.println("changing color to RED");
            rectParallel.setFill(Color.RED);
            break;
        case "Level 3":
            rectParallel.setFill(Color.BLACK);
            break;
        case "Level 1":
        default:
            rectParallel.setFill(Color.DARKBLUE);
        }

        gameArea.getChildren().add(rectParallel);

        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(3000), rectParallel);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), rectParallel);

        translateTransition.setFromX(oldX);
        translateTransition.setToX(newX);
        translateTransition.setFromY(oldY);
        translateTransition.setToY(newY);

        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(2000), rectParallel);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(cycleCount);
        return parallelTransition;
    }

    private ParallelTransition finalBossMovementTransitions() {
        Rectangle rectParallel = new Rectangle(10,200,50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.PURPLE);
        rectParallel.setTranslateX(50);
        rectParallel.setTranslateY(75);

        gameArea.getChildren().add(rectParallel);


        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(3000), rectParallel);
        fadeTransition.setFromValue(2.0f);
        fadeTransition.setToValue(0.5f);
        fadeTransition.setCycleCount(6);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), rectParallel);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(6);
        translateTransition.setAutoReverse(true);
        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(3000), rectParallel);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(6);
        rotateTransition.setAutoReverse(true);
        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(2000), rectParallel);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(3f);
        scaleTransition.setCycleCount(6);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();

        return parallelTransition;
    }


    private void initializeTowerMenu() {

        Tower tower1 = new Tower("Peppermint Tower", 0, "Defends with hard candy");
        Tower tower2 = new Tower("Icing Shoot", 0, "Defends by shooting icing");
        Tower tower3 = new Tower("Puff House", 0, "Defends with pastry puffs");

        ImageView imageViewT1 = new ImageView(tower1.getTowerImage());
        imageViewT1.setId("imageView1");
        imageViewT1.setFitHeight(50);
        imageViewT1.setFitWidth(50);

        ImageView imageViewT2 = new ImageView(tower2.getTowerImage());
        imageViewT2.setFitHeight(50);
        imageViewT2.setFitWidth(50);

        ImageView imageViewT3 = new ImageView(tower3.getTowerImage());
        imageViewT3.setFitHeight(50);
        imageViewT3.setFitWidth(50);

        // BUY TOWERS
        Button tower1BuyButton = new Button("Buy T1");
        tower1BuyButton.setId("buyT1");
        Button tower2BuyButton = new Button("Buy T2");
        tower2BuyButton.setId("buyT2");
        Button tower3BuyButton = new Button("Buy T3");
        tower3BuyButton.setId("buyT3");

        tower1BuyButton.setId("tower1BuyButton");
        tower2BuyButton.setId("tower2BuyButton");
        tower3BuyButton.setId("tower3BuyButton");

        // UPGRADE TOWERS
        Button tower1UpgradeButton = new Button("Upgrade T1");
        tower1BuyButton.setId("upgradeT1");
        Button tower2UpgradeButton = new Button("Upgrade T2");
        tower2BuyButton.setId("upgradeT2");
        Button tower3UpgradeButton = new Button("Upgrade T3");
        tower3BuyButton.setId("upgradeT3");

        tower1BuyButton.setOnMouseClicked(e -> {
            if (money - tower1.getIntPrice() < 0) {
                Alert alertBox = new Alert(Alert.AlertType.ERROR);
                alertBox.setTitle("Error");
                alertBox.setHeaderText("Not Enough Money");
                alertBox.setContentText("Cannot purchase tower with current balance.");
                alertBox.showAndWait();
            } else {
                towersPlaced.add(tower1);
                money = money - tower1.getIntPrice();
                moneyStatus.setText("Money is " + money + " coins");
                Button doneButton = new Button("Click if done placing tower");
                doneButton.setLayoutX(50.00);
                doneButton.setLayoutY(50.00);

                MapTower mapTower1 = new MapTower(tower1, doneButton);


                if (doneButton.isDisable()) {
                    gameArea.getChildren().addAll(mapTower1);
                } else {
                    gameArea.getChildren().addAll(mapTower1, doneButton);
                }

            }
        });

        tower1UpgradeButton.setOnMouseClicked(e -> {
            // old t1 damage = 10
            tower1.setDamage(20);
        });
        tower2UpgradeButton.setOnMouseClicked(e -> {
            tower2.setDamage(30);
        });
        tower3UpgradeButton.setOnMouseClicked(e -> {
            tower3.setDamage(40);
        });

        tower2BuyButton.setOnMouseClicked(e -> {
            if (money - tower2.getIntPrice() < 0) {
                Alert alertBox = new Alert(Alert.AlertType.ERROR);
                alertBox.setTitle("Error");
                alertBox.setHeaderText("Not Enough Money");
                alertBox.setContentText("Cannot purchase tower with current balance.");
                alertBox.showAndWait();
            } else {
                towersPlaced.add(tower2);
                money = money - tower2.getIntPrice();
                moneyStatus.setText("Money is " + money + " coins");
                Button doneButton = new Button("Click if done placing tower");
                MapTower mapTower2 = new MapTower(tower2, doneButton);
                if (doneButton.isDisable()) {
                    gameArea.getChildren().addAll(mapTower2);
                } else {
                    gameArea.getChildren().addAll(mapTower2, doneButton);
                }
            }
        });

        tower3BuyButton.setOnMouseClicked(e -> {
            if (money - tower3.getIntPrice() < 0) {
                Alert alertBox = new Alert(Alert.AlertType.ERROR);
                alertBox.setTitle("Error");
                alertBox.setHeaderText("Not Enough Money");
                alertBox.setContentText("Cannot purchase tower with current balance.");
                alertBox.showAndWait();
            } else {
                towersPlaced.add(tower3);
                money = money - tower3.getIntPrice();
                moneyStatus.setText("Money is " + money + " coins");
                Button doneButton = new Button("Click if done placing tower");
                MapTower mapTower3 = new MapTower(tower3, doneButton);
                if (doneButton.isDisable()) {
                    gameArea.getChildren().addAll(mapTower3);
                } else {
                    gameArea.getChildren().addAll(mapTower3, doneButton);
                }
            }
        });

        switch (difficulty) {
        case "medium":
            tower1.setPrice(25);
            tower2.setPrice(30);
            tower3.setPrice(35);
            break;
        case "hard":
            tower1.setPrice(30);
            tower2.setPrice(35);
            tower3.setPrice(40);
            break; //changes price of tower based on difficulty set
        case "easy":
        default:
            tower1.setPrice(20);
            tower2.setPrice(25);
            tower3.setPrice(30);
        }

        towerMenu = new HBox();
        // Tower menu HBOX settings
        towerMenu.setPrefSize(400, 400);
        towerMenu.setTranslateX(130);
        towerMenu.setTranslateY(-100);
        towerMenu.setAlignment(Pos.CENTER);
        towerMenu.setSpacing(50);

        // Individual tower Vboxes
        VBox tower1Box = new VBox();
        tower1Box.getChildren().addAll(imageViewT1, tower1.getName(),
                tower1.getPrice(), tower1.getDescription(),
                tower1BuyButton, tower1UpgradeButton, tower1.getDamageLabel());
        tower1Box.setId("towerBox1");
        VBox tower2Box = new VBox();
        tower2Box.getChildren().addAll(imageViewT2, tower2.getName(),
                tower2.getPrice(), tower2.getDescription(),
                tower2BuyButton, tower2UpgradeButton, tower2.getDamageLabel());
        VBox tower3Box = new VBox();
        tower3Box.getChildren().addAll(imageViewT3, tower3.getName(),
                tower3.getPrice(), tower3.getDescription(),
                tower3BuyButton, tower3UpgradeButton, tower3.getDamageLabel());
        // Add all Vboxes to HBox
        towerMenu.getChildren().addAll(tower1Box, tower2Box, tower3Box);
    }
    public void displayMoneyButton(double x, double y) throws FileNotFoundException {
        Button coin = new Button();
        coin.setTranslateX(x); //300
        coin.setTranslateY(y); //0
        Image img = new Image(new FileInputStream("./assets/dollar2.png"));
        ImageView view = new ImageView(img);
        view.setFitHeight(24);
        view.setFitWidth(50);
        coin.setGraphic(view);
        gameArea.getChildren().add(coin);

        coin.setOnMouseClicked(e -> {
            money = money + 15;
            moneyStatus.setText("Money is " + money + " coins");
            coin.setVisible(false);
            coin.setDisable(true);
        });
        coin.setId("coinButton");
    }
    public void goToEndScreen(int width, int height, Image endScreenImage, int moneyP, double healthP, int armyH) throws IOException {
        GameOverScreen screen = new GameOverScreen(width, height, endScreenImage, moneyP, healthP, armyH);
        this.width = width;
        this.height = height;
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public double getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public String getDifficulty() {
        return difficulty;
    }

}
