package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import logger.Logger;
import org.openqa.selenium.WebDriver;

public class BrowserFabric {
    public static WebDriver initBrowser() {
        Logger.initLogger();
        Logger.debug("Creating driver");
        switch (BrowserOptions.getSettings().getBrowser()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return BrowserOptions.configChromeBrowser();
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                return BrowserOptions.configFireFoxBrowser();
            }
            default: {
                return null;
            }
        }
    }
}
