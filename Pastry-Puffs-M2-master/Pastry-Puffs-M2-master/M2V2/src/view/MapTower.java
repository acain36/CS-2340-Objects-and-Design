package src.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;

public class MapTower extends Pane {
    private Image mapTowerImage;
    private ImageView mtImgView;
    private Button doneButton;

    public MapTower(Tower towerSource, Button doneButton) {

        mapTowerImage = towerSource.getTowerImage();
        mtImgView = new ImageView(mapTowerImage);
        mtImgView.setFitWidth(50);
        mtImgView.setFitHeight(50);
        this.getChildren().addAll(mtImgView);

        //double usedX;
        //double usedY;

        this.doneButton = doneButton;

        /**if (test) {
           usedX = x;
           usedY = y;
        }*/

        mtImgView.setOnMouseDragged(m -> {
            double x = mtImgView.getLayoutX() + m.getX();
            double y = mtImgView.getLayoutY() + m.getY();
            mtImgView.setLayoutX(x);
            mtImgView.setLayoutY(y);
            System.out.println("X:" + mtImgView.getLayoutX());
            System.out.println("Y:" + mtImgView.getLayoutY());
            towerSource.setXTower(mtImgView.getLayoutX());
            towerSource.setYTower(mtImgView.getLayoutY());
            System.out.println("X in tower source:" + towerSource.getXTower());
            System.out.println("Y in tower source:" + towerSource.getYTower());
            //placeTower(towerSource, x, y);

        });
        doneButton.setOnAction(e -> {
            if (mtImgView.getLayoutX() >= 0 && mtImgView.getLayoutX() < 53) {
                if (mtImgView.getLayoutY() > 358 && mtImgView.getLayoutY() < 418) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else if (mtImgView.getLayoutX() >= 53 && mtImgView.getLayoutX() < 115) {
                if (mtImgView.getLayoutY() > 101 && mtImgView.getLayoutY() < 418) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else if (mtImgView.getLayoutX() >= 115 && mtImgView.getLayoutX() < 246) {
                if (mtImgView.getLayoutY() > 101 && mtImgView.getLayoutY() < 175) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else if (mtImgView.getLayoutX() >= 246 && mtImgView.getLayoutX() < 340) {
                if (mtImgView.getLayoutY() > 101 && mtImgView.getLayoutY() < 175) {
                    displayAlertAndReset();
                } else if (mtImgView.getLayoutY() > 255 && mtImgView.getLayoutY() < 470) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else if (mtImgView.getLayoutX() >= 340 && mtImgView.getLayoutX() < 460) { //E
                if (mtImgView.getLayoutY() > 101 && mtImgView.getLayoutY() < 175) {
                    displayAlertAndReset();
                } else if (mtImgView.getLayoutY() > 255 && mtImgView.getLayoutY() < 345) {
                    displayAlertAndReset();
                } else if (mtImgView.getLayoutY() > 379 && mtImgView.getLayoutY() < 470) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else if (mtImgView.getLayoutX() >= 460 && mtImgView.getLayoutX() < 540) { //F
                if (mtImgView.getLayoutY() > 101 && mtImgView.getLayoutY() < 175) {
                    displayAlertAndReset();
                } else if (mtImgView.getLayoutY() > 255 && mtImgView.getLayoutY() < 345) {
                    displayAlertAndReset();
                } else if (mtImgView.getLayoutY() > 355 && mtImgView.getLayoutY() < 470) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else if (mtImgView.getLayoutX() >= 540 && mtImgView.getLayoutX() < 610) {
                if (mtImgView.getLayoutY() > 101 && mtImgView.getLayoutY() < 345) {
                    displayAlertAndReset();
                } else {
                    setButton();
                }
            } else {
                doneButton.setVisible(false);
                doneButton.setDisable(false);
            }
        });


    }
    private void setButton() {
        doneButton.setVisible(false);
        doneButton.setDisable(false);
    }

    private void displayAlertAndReset() {
        Alert alertBox = new Alert(Alert.AlertType.ERROR);
        alertBox.setTitle("Error");
        alertBox.setHeaderText("Invalid Location");
        alertBox.setContentText("Don't place tower on path!");
        alertBox.showAndWait();
        mtImgView.setLayoutX(50);
        mtImgView.setLayoutY(50);
    }

    /**private void placeTower(double x, double y) {

    }*/
}