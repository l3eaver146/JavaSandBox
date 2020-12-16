package testSteps;

import fileUtil.FileUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestResult;
import logger.Logger;
import org.junit.Assert;
import pages.InstallationPage;
import waitUtil.WaitUtil;

public class SteamInstallationSteps {
    public SteamInstallationSteps() {
        installationPage = new InstallationPage();
    }

    private final InstallationPage installationPage;

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
        boolean isFileDownloaded = FileUtil.isFileExists("SteamSetup.exe");
        Logger.step("\n\n Assert : SteamSetup appeared? ");
        Assert.assertTrue("File wasn't downloaded", isFileDownloaded);
        TestResult result = new TestResult();
        Logger.info("Steps failed : " + result.failureCount());
    }
}
