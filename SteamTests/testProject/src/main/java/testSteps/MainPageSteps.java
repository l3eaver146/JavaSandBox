package testSteps;

import browserFactory.Browser;
import browserFactory.config.ApplicationConfig;
import fileUtil.FileUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import logger.Logger;
import org.junit.Assert;
import pages.MainPage;

public class MainPageSteps {
    public MainPageSteps() {
        mainPage = new MainPage();
    }

    private final MainPage mainPage;

    @Given("I launch application")
    public void launchApplication() {
        ApplicationConfig settings = FileUtil.getApplicationConfig();
        String appUrl = settings.getProtocol() + settings.getServer() + settings.getResource();
        Logger.step("\n\n Step number 1 : Trying to open application ");
        Browser.getInstance().openUrl(appUrl);
        Logger.step("\n\n Assert : Main page opened? ");
        Assert.assertTrue("Main page wasn't opened", mainPage.isPageOpened());
    }

    @When("I open action games page")
    public void openActionGamesPage() {
        Logger.step("\n\n Step number 2 : Trying to open action game page ");
        mainPage.clickBrowseButton();
        mainPage.getGamesSubMenu().clickActionButton();
    }
}
