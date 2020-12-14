package waitUtil;

import browserFactory.Browser;
import elements.BaseElement;
import fileUtil.FileUtil;
import logger.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WaitUtil {
    private static WebDriverWait wait;
    private static final long WAITING_TIME = FileUtil.getFrameworkConfig().getWaitingTime();

    public static long getWaitingTime() {
        return WAITING_TIME;
    }

    public static void waitForFileToDownload(String fileName) {
        Logger.debug("Waiting for " + fileName + " will appear in " + FileUtil.getPathToDownloadDirectory());
        File file = new File(FileUtil.getPathToDownloadDirectory() + fileName);
        FluentWait wait = new FluentWait(Browser.getInstance())
                .withTimeout(WAITING_TIME, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS);
        wait.until((isExists) -> file.exists());
    }
}
