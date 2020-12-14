package browserFactory;

import fileUtil.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class BrowserFactory {
    public static WebDriver initBrowser() {
        Logger.info("Creating driver");
        Browsers browsers = Objects.requireNonNull(Browsers.getByName(FileUtil.getFrameworkConfig().getBrowser()));
        switch (browsers) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new OptionsFactory().setOptions(browsers));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new OptionsFactory().setOptions(browsers));
            }
            default -> {
                return new ChromeDriver();
            }
        }
    }
}
