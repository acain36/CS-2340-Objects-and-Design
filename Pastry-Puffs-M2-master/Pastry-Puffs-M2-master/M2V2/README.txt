In designing our tests, we decided that the person who worked on a certain screen would
create at least one unit test to test an important functional aspect of that screen.
Shravani was responsible for the Enter Game button implementation that took the configuration screen to the game
screen, as well as the specific restrictions for the name field in this screen. Shravani chose to test that the error
handling works when the text field in the configurations screen is left empty. Assuming that the Start Game and
Enter Game button work, the test clicks through both buttons. When going from these two buttons, the name
text field is kept empty in order to replicate a name error case. Using the verifyThat method, the code
tests that the error message text for an empty name field is visible on the current screen. This shows that the
Enter Game button correctly implements the error handling, since it restricts the user from accessing the
third screen when an invalid name is entered. Ashley was responsible for the graphic design of the background
screen of the ThirdScreen. This included creating the
visual path and the visual of the tower. This image was implemented in the background of the ThirdScreen which also
includes visual labels representing the money and health status of the player. Ashley tested the startGame and
enterGame buttons on the first and second screens, ensuring that they lead to the display of the third screen
This test uses the assertTrue method to ensure that there is a screen showing following the clicking of
both of these buttons. Varshini was responsible for the implementation of the design of screen two.
Varshini chose to test that the prompts that ask the player for their details were correctly displayed.
In the test, the start button takes the game
to the second screen. The test then looks for 2 labels, matching the prompt for Name and Difficulty. The test then passes
if those prompts are correctly displayed. Similar to Varshini's test, Noopur's test looks for matching the prompt for Name.
The test passes if those prompts are correctly displayed. Lastly, Ananya's test checks to see that the initial game map
is uploaded to the third screen when the enter game button is clicked on the second screen.


M3 TEST DESCRIPTION:
Based off of the functionality tested by M2 tests (description above), we created tests for M3:
- Noopur two tests and Ashley's first test analyze and verify the functionality of the three tower purchase buttons.
Testing the functionality of these buttons is imperative due to the fact that they allow the towers to be placed and bought by the player.
These three tests verify that the buttons are not null, thereby ensuring that the player can buy and place towers with the appropriate functionality.

- Shravani's two tests and Varshini's first test verifies that the prices for each tower displayed on the tower menu
changes based off what difficultly is chosen by the user. These three tests click through each screen and specifically
test different difficulties to see if the corresponding tower prices for that difficulty level is visible on the game screen.
This functionality is important to test, since the change in prices for each of the towers plays a large role in the
difficulty of the game itself.


- Varhshini's second test verifies that the money shown on the screen updates when a tower is bought. Specifically, the code
tests on the easy difficulty level, where if a gingerbread tower (tower1) is bought by clicking the Tower1BuyButton,
the total money on the screen should go down by the price of that tower (the money goes from 100 to 80).
This functionality is important since the money updating with each tower purchase allows the player to keep
track of how much money they have left in the game.

-Ananya's 2 tests continue to check that buying the type2 and type3 towers update the money accordingly
Buying tower2 decreases money by 25 coins. Buying tower3 decreases money by 30 coins. Related to this, Ashley's 2nd M3 test checks to make sure that the player has enough money left to buy more towers if they so desire. If they don't the player sees an error message that is displayed saying they don't have enough money. This is important because it prevents the player for having negative money.


M4 Test Description

Ananya's 2 tests test to check that health decreases when the level is medium. The second test checks that that game over screen shows up when health is zero. Both of these are important since it checks that health gets updated appropriately and that the game stop when player runs out of health. 

Noopur’s first two tests for M4 verify that the activate enemies button is present and working for the easy and medium level. Testing the functionality of this specific button is imperative to ensure that the enemies appear and can begin to traverse the path. Similarly, ensuring that the button works on multiple levels is important for the overall functionality and implementation of the game. Thus, Varshini’s first test also examines the activate enemies button, but for the hard level. 

Ashley's Tests check the final health of the castle after all 10 enemies attack during the hard level. Completes this by checking that there is 60% displayed as the health value to the player. Additionally, the second test checks to see that the initial health displayed when playing on easy is 100%.

Shravani's 2 tests check the functionality of the two buttons on the gameOver Screen. The first of the two tests check that when clicking the restart game screen, a screen is still shown, proving that
the welcome screen will appear. The second test shows that if the quit game button is clicked, no screen will show up, signifying that the application closed.

Varshini's second test checks that the health decrements by 10 when an enemy reaches the castle. This is tested through checking that by the time one enemy reaches the castle,
the text "Health is 90%" is on the screen.


M5 Test Description

Varshini's first test checks that a level is asked for in the second screen. This is done by checking if a label with text 'label' is displayed. Varshini's second test checks that the initial enemy health is displayed when the third screen (main game screen) is entered into.

Shravani's two tests test that for level 2 and 3 (for easy difficulty), there is a different type of enemy on the screen. This is tested by checking that the enemy health is correct(different for each enemy type) when displayed on the third screen.

Noopur's two tests check the money gain functionality we needed to implement. The first test checks that by clicking the 1st money button that is displayed when the enemies are invading, the money increases by the correct amount.
The second test checks that the second money button works and increases the money of the player, as well.

Ananya's two tests and Ashley's first check that each level 1, 2, and 3 are displayed on the second screen where the player selects difficulty and what level they're on.

Ashley's last test checks that the enemy (1st type) that is supposed to show up for level 1 games, is displayed on the third screen regardless of what difficulty level is selected.
She tested this by checking to see that the same enemy health from level 1 easy was displayed on the third screen of level 1 medium difficulty.


M6 Test Descriptions:

The first two tests are Ashley's tests for the tower upgrade buttons. The first tests the tower 1 upgrade button for easy, level 1, and the second tests the tower 2 upgrade button for easy, level 1.

The next two tests are Ananya's tests for the tower upgrade buttons. The first tests the tower 3 upgrade button for easy, level 1, and the second tests the tower 1 upgrade button for medium, level 1.

The next two tests are Noopur's tests for the tower upgrade buttons. The first tests the tower 2 upgrade button for medium, level 1, and the second tests the tower 3 upgrade button for medium, level 1.

The next two tests are Shravani's tests for the tower upgrade buttons. The first tests the tower 1 upgrade button for hard, level 1, and the second tests the tower 2 upgrade button for hard, level 1.

The final two tests are Varshini's tests for the tower upgrade buttons. The first tests the tower 3 upgrade button for hard, level 1, and the second tests the tower 3 upgrade button for hard, level 2.
