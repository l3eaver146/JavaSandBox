package testSteps;

import helpers.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logger.Logger;
import models.Game;
import org.junit.Assert;
import pages.ActionGamesPage;
import pages.ConfirmAgePage;
import pages.elements.GameBlockForm;

import static helpers.LocParts.*;

public class ActionGamesPageSteps {
    public ActionGamesPageSteps() {
        actionGamesPage = new ActionGamesPage();
        confirmAgePage = new ConfirmAgePage();
    }

    private final ActionGamesPage actionGamesPage;
    private final ConfirmAgePage confirmAgePage;

    @Then("Action games page has opened")
    public void isActionGamePageOpened() {
        Logger.step("\n\n Assert : Action game page opened? ");
        Assert.assertTrue("Action games page wasn't opened", actionGamesPage.isPageOpened());
    }

    @When("I choose top sellers tab on Action game page")
    public void goToTopSellersTab() {
        Logger.step("\n\n Step number 3 : Trying to pen top sellers tab ");
        actionGamesPage.clickTopSellersButton();
    }

    @And("I open maximal discount game page and save this data in {string}")
    public void OpenMaximalDiscountGamePageAndSaveData(String gameData) {
        Logger.step("\n\n Step number 4 : Trying to open game with maximal discount page ");
        int maxDiscountGameIndex = actionGamesPage.getGameBlockList().getIndexOfGameWithMaxDiscount();
        GameBlockForm gameBlockForm = actionGamesPage.getGameBlockList().getGameBlockByNumberInList(maxDiscountGameIndex);
        Game game = new Game(
                gameBlockForm.getFieldValue(PRICE),
                gameBlockForm.getFieldValue(DISCOUNT),
                gameBlockForm.getFieldValue(FINAL_PRICE),
                gameBlockForm.getFieldValue(NAME)
        );
        actionGamesPage.getGameBlockList().clickBlockByName(game.getName());
        ScenarioContext.setContext(gameData, game);
        if (confirmAgePage.isPageOpened()) {
            confirmAgePage.abuseAgeControl();
        }
    }
}
