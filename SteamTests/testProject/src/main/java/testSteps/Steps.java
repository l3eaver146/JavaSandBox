package testSteps;

import browserFactory.Browser;
import browserFactory.Config;
import fileUtil.FileUtil;
import helpers.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.TestResult;
import logger.Logger;
import models.GameDataModel;
import org.junit.Assert;
import org.junit.runner.RunWith;
import pages.*;
import waitUtil.WaitUtil;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/features/")
public class Steps {
    private final MainPage mainPage;
    private final ActionGamesPage actionGamesPage;
    private final ScenarioContext scenarioContext;
    private final ConfirmAgePage confirmAgePage;
    private final PersonalGamePage personalGamePage;
    private final InstallationPage installationPage;

    public Steps() {
        mainPage = new MainPage();
        actionGamesPage = new ActionGamesPage();
        scenarioContext = new ScenarioContext();
        confirmAgePage = new ConfirmAgePage();
        personalGamePage = new PersonalGamePage();
        installationPage = new InstallationPage();
    }

    @Given("I launch application")
    public void launchApplication() {
        Config settings = FileUtil.getFrameworkConfig();
        String appUrl = settings.getProtocol() + settings.getServer() + settings.getResource();
        Logger.step("\n\n Step number 1 : Trying to open application ");
        Browser.openUrl(appUrl);
        Logger.step("\n\n Assert : Main page opened? ");
        Assert.assertTrue("Main page wasn't opened", mainPage.isPageOpened());
    }

    @When("I open action games page")
    public void openActionGamesPage() {
        Logger.step("\n\n Step number 2 : Trying to open action game page ");
        mainPage.clickBrowseButton();
        mainPage.getGamesSubMenu().clickActionButton();
    }

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
        int index = actionGamesPage.getGameBlockList().getIndexOfGameBlockWithMaxDiscount();
        actionGamesPage.getGameBlockList().findBlockWithMaxDiscount(index);
        GameDataModel game = actionGamesPage.getGameBlockList().getGameBlock().getGameData();
        scenarioContext.setContext(gameData, game);
        actionGamesPage.getGameBlockList().clickOnGameBlock();
        if (confirmAgePage.isPageOpened()) {
            confirmAgePage.abuseAgeControl();
        }
    }

    @Then("Game data obtained in previous step corresponds to the displayed")
    public void isGameDataCorrect() {
        Logger.step("\n\n Assert: Game page opened?");
        Assert.assertTrue("Game page wasn't opened", personalGamePage.isPageOpened());
        Logger.step("\n\n Assert : Game data correct? ");
        GameDataModel gameData = personalGamePage.getAllGameInfo();
        GameDataModel gameDataFromPreviousStep = (GameDataModel) scenarioContext.getContext("gameData");
        Assert.assertEquals("Something wrong with game data on personal page", gameData, gameDataFromPreviousStep);
    }

    @When("I go to install steam page")
    public void goToInstallSteamPage() {
        Logger.step("\n\n Step number 5 : Trying to open installation page");
        personalGamePage.clickInstallButton();
    }

    @Then("Installation page has opened")
    public void isInstallationPageOpened() {
        Logger.step("\n\n Assert : Installation page opened?");
        Assert.assertTrue("Installation page wasn't opened", installationPage.isPageOpened());
    }

    @When("I install steam")
    public void installSteam() {
        Logger.step("\n\n Step number 6 : Trying install steam");
        installationPage.clickInstallSteamButton();
    }

    @Then("File appeared in resources folder")
    public void isFileAppearedInResourcesFolder() {
        WaitUtil.waitForFileToDownload("SteamSetup.exe");
        boolean isFileDownloaded = FileUtil.checkFileExists("SteamSetup.exe");
        Logger.step("\n\n Assert : SteamSetup appeared? ");
        Assert.assertTrue("File wasn't downloaded", isFileDownloaded);
        TestResult result = new TestResult();
        Logger.debug("Steps failed : " + result.failureCount());
    }
}
