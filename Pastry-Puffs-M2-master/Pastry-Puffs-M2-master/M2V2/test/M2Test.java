import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import src.controller.Controller;

import static org.testfx.api.FxAssert.verifyThat;

//extra imports!

public class M2Test extends ApplicationTest {
    private final Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller.start(primaryStage);
        primaryStage.show();
    }

    @BeforeClass
    public static void config() throws Exception {
        System.getProperties().put("testfx.robot", "glass");
    }



    // Ananya's Test for Start Game Button - verify that it exists
    /**@Test
    public void testGameMap() {
        clickOn("#startgame");
        clickOn("#entergame");
        Assert.assertTrue(controller.getMainWindow().isShowing());
    }

    //Shravani's Test for Enter Game Button
    // Tests Case that the name field in the configuration window
    // is left empty when clicking EnterGame button
    @Test
    public void testEnterButton() {
        clickOn("#startgame");
        clickOn("#entergame");
        verifyThat("Please enter a valid name", NodeMatchers.isNotNull());
    }

    // Ashley's Test for Third Screen Functionality
    @Test
    public void testAccessThirdScreen() {
        clickOn("#startgame");
        clickOn("#entergame");
        Assert.assertTrue(controller.getMainWindow().isShowing());
    }

    // Noopur's Test for the Second Screen
    // Tests that name is asked for
    @Test
    public void testAskForName() {
        clickOn("#startgame");
        verifyThat("Name: ", NodeMatchers.isNotNull());
    }

    // Varshini's Test for the Second Screen
    // Tests that difficulty is asked for
    @Test
    public void testAskForDifficulty() {
        clickOn("#startgame");
        verifyThat("Difficulty: ", NodeMatchers.isNotNull());
    }

    // ALL THE FOLLOWING TESTS ARE FOR M3


    // Noopur's M3 Tests
    @Test
    public void testTowerBuyButton1() {
        clickOn("#startgame");
        clickOn("#username");
        write("lol");
        clickOn("#easy");
        clickOn("#entergame");
        verifyThat("#tower1BuyButton", NodeMatchers.isNotNull());
    }
    // Noopur's M3 Tests
    @Test
    public void testTowerBuyButton2() {
        clickOn("#startgame");
        clickOn("#username");
        write("lol");
        clickOn("#easy");
        clickOn("#entergame");
        verifyThat("#tower2BuyButton", NodeMatchers.isNotNull());
    }
    // Ashley's M3 Tests
    @Test
    public void testTowerBuyButton3() {
        clickOn("#startgame");
        clickOn("#username");
        write("lol");
        clickOn("#easy");
        clickOn("#entergame");
        verifyThat("#tower3BuyButton", NodeMatchers.isNotNull());
    }

    // Ashley's M3 Tests
    @Test
    public void enoughMoney() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ananya");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#tower2BuyButton");
        clickOn("#tower2BuyButton");
        clickOn("#tower1BuyButton");
        clickOn("#tower1BuyButton");
        clickOn("#tower1BuyButton");
        verifyThat("Cannot purchase tower with current balance.", NodeMatchers.isNotNull());
    }




    // Shravani's M3 Tests
    @Test
    public void testEasyTowerMenuPrice() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#easy");
        clickOn("#entergame");
        verifyThat("20", NodeMatchers.isNotNull());
        verifyThat("25", NodeMatchers.isNotNull());
        verifyThat("30", NodeMatchers.isNotNull());


    }

    // Shravani's M3 Tests
    @Test
    public void testMediumTowerMenuPrice() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#medium");
        clickOn("#entergame");
        verifyThat("25", NodeMatchers.isNotNull());
        verifyThat("30", NodeMatchers.isNotNull());
        verifyThat("35", NodeMatchers.isNotNull());
    }

    //Varshini's M3 Tests

    @Test
    public void testHardTowerMenuPrice() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#hard");
        clickOn("#entergame");
        verifyThat("30", NodeMatchers.isNotNull());
        verifyThat("35", NodeMatchers.isNotNull());
        verifyThat("40", NodeMatchers.isNotNull());
    }
    //tests that the money updates after buying a tower1 (gingerbread tower)
    @Test
    public void testMoney1() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#tower1BuyButton");
        verifyThat("Money is 80 coins", NodeMatchers.isNotNull());
    }

    //Ananya's M3 Tests

    @Test
    public void testMoney2() { //tests money updates after buying a tower2 (icing shoot)
        clickOn("#startgame");
        clickOn("#username");
        write("Ananya");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#tower2BuyButton");
        verifyThat("Money is 75 coins", NodeMatchers.isNotNull());
    }

    //Ananya's M3 Tests
    @Test
    public void testMoney3() { //tests money updates after buying a tower3 (puff house)
        clickOn("#startgame");
        clickOn("#username");
        write("Ananya");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#tower3BuyButton");
        verifyThat("Money is 70 coins", NodeMatchers.isNotNull());
    }

    // M4 Tests!
    // Noopur's M4 Tests
    @Test
    public void testStartEnemyButtonEasy() {
        clickOn("#startgame");
        clickOn("#username");
        write("lol");
        clickOn("#easy");
        clickOn("#entergame");
        verifyThat("#activateEnemiesButton", NodeMatchers.isNotNull());
    }
    // Noopur's M4 Tests
    @Test
    public void testStartEnemyButtonMedium() {
        clickOn("#startgame");
        clickOn("#username");
        write("lol");
        clickOn("#medium");
        clickOn("#entergame");
        verifyThat("#activateEnemiesButton", NodeMatchers.isNotNull());
    }
    // Varshini's M4 Tests
    @Test
    public void testStartEnemyButtonHard() {
        clickOn("#startgame");
        clickOn("#username");
        write("lol");
        clickOn("#hard");
        clickOn("#entergame");
        verifyThat("#activateEnemiesButton", NodeMatchers.isNotNull());
    }
    //Varshini's M4 Test
    @Test
    public void testHealthDecrementEasy() {
        clickOn("#startgame");
        clickOn("#username");
        write("test");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 13000) {
            System.out.println();
        }
        verifyThat("Health is 90%", NodeMatchers.isNotNull());
    }
    //Shravani's M4 Test
    @Test
    public void testGameOverRestartButton() {
        clickOn("#startgame");
        clickOn("#username");
        write("test");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 23000) {
            System.out.println();
        }
        clickOn("#restartgame");
        Assert.assertTrue(controller.getMainWindow().isShowing());
    }
    //Shravani's M4 Test
    @Test
    public void testGameOverQuitButton() {
        clickOn("#startgame");
        clickOn("#username");
        write("test");
        clickOn("#easy");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 23000) {
            System.out.println();
        }
        clickOn("#quitgame");
        Assert.assertFalse(controller.getMainWindow().isShowing());
    }

    //Ananya's Test Cases
    @Test
    public void testGoToGameOver() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ananya");
        clickOn("easy");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        //wait(5000);
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 25000) {
            System.out.println();
        }
        Assert.assertTrue(controller.getMainWindow().isShowing());
    }

    @Test
    public void testHealthDecrementMedium() {
        clickOn("#startgame");
        clickOn("#username");
        write("test");
        clickOn("#medium");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 13000) {
            System.out.println();
        }
        verifyThat("Health is 75%", NodeMatchers.isNotNull());
    }
    //Ashley M4 Tests
    @Test
    public void testFinalHealthHard() {
        clickOn("#startgame");
        clickOn("#username");
        write("ashley");
        clickOn("#hard");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 13000) {
            System.out.println();
        }
        verifyThat("Health is 60%", NodeMatchers.isNotNull());
    }

    @Test
    public void testInitialHealthEasy() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#easy");
        clickOn("#entergame");
        verifyThat("Health is 100%", NodeMatchers.isNotNull());
    }

    **/

    //Varshini M5 Tests
    //Tests that level is asked for
    @Test
    public void testLevelButtons() {
        clickOn("#startgame");
        clickOn("#username");
        write("Varshini");
        verifyThat("Level: ", NodeMatchers.isNotNull());
    }

    //Tests that enemy health is displayed
    @Test
    public void testEnemyHealthDisplay() {
        clickOn("#startgame");
        clickOn("#username");
        write("Varshini");
        clickOn("#easy");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("Enemy Health: 100", NodeMatchers.isNotNull());
    }

    //Shravani's Tests
    //Tests that enemy health for level 2 enemy is displayed and different.
    @Test
    public void testEnemyHealthLevel2() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#easy");
        clickOn("#level2");
        clickOn("#entergame");
        verifyThat("Enemy Health: 150", NodeMatchers.isNotNull());
    }

    //Tests that enemy health for level 3 enemy is displayed and different.
    @Test
    public void testEnemyHealthLevel3() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#easy");
        clickOn("#level3");
        clickOn("#entergame");
        verifyThat("Enemy Health: 250", NodeMatchers.isNotNull());
    }
    //Noopur's Tests
    //tests that the money button increases money
    @Test
    public void testMoneyButtonIncrease() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#easy");
        clickOn("#level1");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 8000) {
            System.out.println();
        }
        clickOn("#coinButton");
        verifyThat("Money is 115 coins", NodeMatchers.isNotNull());
    }

    //tests that the money button increases money when clicked twice.
    @Test
    public void testMoneyButtonIncrease2() {
        clickOn("#startgame");
        clickOn("#username");
        write("Shravani");
        clickOn("#easy");
        clickOn("#level1");
        clickOn("#entergame");
        clickOn("#activateEnemiesButton");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 5000) {
            System.out.println();
        }
        clickOn("#coinButton");
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 4000) {
            System.out.println();
        }
        clickOn("#coinButton");
        verifyThat("Money is 130 coins", NodeMatchers.isNotNull());
    }
    //Ananya's Tests
    @Test
    public void testLevel1Button() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ananya");
        verifyThat("Level 1", NodeMatchers.isNotNull());
    }

    @Test
    public void testLevel2Button() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ananya");
        verifyThat("Level 2", NodeMatchers.isNotNull());
    }

    //Ashley's Test
    @Test
    public void testLevel3Button() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        verifyThat("Level 3", NodeMatchers.isNotNull());
    }

    //This shows that both the medium and easy difficultly level 1 shows the same
    @Test
    public void testEnemyHealthDisplayMatch() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#medium");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("Enemy Health: 100", NodeMatchers.isNotNull());
    }

    //M6 Tests
    @Test
    public void TestTower1Update() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#easy");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT1",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower2Upgrade() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#easy");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT2",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower3Upgrade() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#easy");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT3",  NodeMatchers.isNotNull());
    }


    @Test
    public void TestTower1UpgradeMedium() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#medium");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT1",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower2UpgradeMedium() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#medium");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT2",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower3UpgradeMedium() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#medium");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT3",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower1UpgradeHard() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#hard");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT1",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower2UpgradeHard() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#hard");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT2",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTower3UpgradeHard() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#hard");
        clickOn("#level1");
        clickOn("#entergame");
        verifyThat("#upgradeT3",  NodeMatchers.isNotNull());
    }

    @Test
    public void TestTowerUpgradeOnNewLevel() {
        clickOn("#startgame");
        clickOn("#username");
        write("Ashley");
        clickOn("#hard");
        clickOn("#level2");
        clickOn("#entergame");
        verifyThat("#upgradeT3",  NodeMatchers.isNotNull());
    }
}


