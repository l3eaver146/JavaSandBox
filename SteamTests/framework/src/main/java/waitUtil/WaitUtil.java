package waitUtil;

import browserFactory.Browser;
import browserFactory.config.FrameworkConfig;
import fileUtil.FileUtil;
import logger.Logger;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WaitUtil {
    private static WebDriverWait wait;
    private static long WAITING_TIME;

    public static long getWaitingTime() {
        try{
            WAITING_TIME = FileUtil.<FrameworkConfig>getFrameworkConfig().getWaitingTime();
        }catch(Exception exception){
            Logger.error(exception.getMessage());
        }
        return WAITING_TIME;
    }

    public static void waitForFileToDownload(String fileName) {
        Logger.info("Waiting for " + fileName + " will appear in " + FileUtil.getPathToDownloadDirectory());
        File file = new File(FileUtil.getPathToDownloadDirectory() + fileName);
        FluentWait<?> wait = new FluentWait<>(Browser.getInstance())
                .withTimeout(WAITING_TIME, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS);
        wait.until((isExists) -> file.exists());
    }
}
