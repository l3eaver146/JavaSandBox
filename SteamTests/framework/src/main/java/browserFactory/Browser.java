package browserFactory;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Browser {
    private Browser() {
        this.driver = BrowserFabric.initBrowser();
    }

    private WebDriver driver;
    private static Browser instance;

    public static WebDriver getDriver() {

        return instance.driver;
    }

    public static WebDriver getInstance() {
        if (instance == null)
            instance = new Browser();
        return instance.driver;
    }

    public static void loadApplication(String url) {
        instance.driver.get(url);
    }

    public static void exitDriver() {
        instance.driver.quit();
    }

    public static void refreshCurrentPage() {
        instance.driver.navigate().refresh();
    }

    public static void switchToLastHandle() {
        Set<String> windowHandles = instance.driver.getWindowHandles();
        instance.driver.switchTo().window(windowHandles.toArray()[getWindowHandlesCount() - 1].toString());
    }

    public static void switchToDefaultContent() {
        Set<String> windowHandles = instance.driver.getWindowHandles();
        instance.driver.switchTo().window(windowHandles.toArray()[0].toString());
    }

    public static void closeCurrentPage() {
        instance.driver.close();
    }

    public static int getWindowHandlesCount() {
        return instance.driver.getWindowHandles().size();
    }
}
