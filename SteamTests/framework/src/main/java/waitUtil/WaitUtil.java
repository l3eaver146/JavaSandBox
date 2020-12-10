package waitUtil;

import browserFactory.Browser;
import browserFactory.BrowserOptions;
import elements.BaseElement;
import logger.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WaitUtil {
    private static WebDriverWait wait;
    private static final long timeSpan = BrowserOptions.getSettings().getWaitingTime();

    public static void waitForClickable(BaseElement element) {
        Logger.debug("Waiting for clickable : " + element.getName());
        wait = new WebDriverWait(Browser.getDriver(), timeSpan);
        wait.until(ExpectedConditions.elementToBeClickable(element.getLocator()));
    }

    public static void waitForDisplayed(BaseElement element) {
        Logger.debug("Waiting for displayed : " + element.getName());
        wait = new WebDriverWait(Browser.getDriver(), timeSpan);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element.getLocator()));
    }

    public static void waitForFileToDownload(String fileName) {
        Logger.debug("Waiting for " + fileName + " will appear in " + BrowserOptions.getDownloadDirectoryPath());
        File file = new File(BrowserOptions.getDownloadDirectoryPath() + fileName);
        FluentWait wait = new FluentWait(Browser.getDriver())
                .withTimeout(timeSpan, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS);
        wait.until((isExists) -> file.exists());
    }
}
