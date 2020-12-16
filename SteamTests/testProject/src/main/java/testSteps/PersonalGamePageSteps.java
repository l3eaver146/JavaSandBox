package testSteps;

import helpers.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logger.Logger;
import models.Game;
import org.junit.Assert;
import pages.PersonalGamePage;

public class PersonalGamePageSteps {
    public PersonalGamePageSteps() {
        personalGamePage = new PersonalGamePage();
    }

    private final PersonalGamePage personalGamePage;

    @Then("Game data obtained in previous step corresponds to the displayed")
    public void isGameDataCorrect() {
        Logger.step("\n\n Assert: Game page opened?");
        Assert.assertTrue("Game page wasn't opened", personalGamePage.isPageOpened());
        Logger.step("\n\n Assert : Game data correct? ");
        Game gameData = personalGamePage.getAllGameInfo();
        Game gameDataFromPreviousStep = (Game) ScenarioContext.getContext("gameData");
        Assert.assertEquals("Something wrong with game data on personal page", gameData, gameDataFromPreviousStep);
    }

    @When("I go to install steam page")
    public void goToInstallSteamPage() {
        Logger.step("\n\n Step number 5 : Trying to open installation page");
        personalGamePage.clickInstallButton();
    }
}
