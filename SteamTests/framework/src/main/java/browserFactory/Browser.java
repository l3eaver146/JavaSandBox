package browserFactory;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Browser {
    private Browser() {
        this.driver = BrowserFactory.initBrowser();
    }

    private WebDriver driver;
    private static Browser instance;
    private static final int LAST_WIDOW_HANDLE_NUMBER = -1;
    private static final int FIRST_WIDOW_HANDLE_NUMBER = 0;

    public static WebDriver getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance.driver;
    }

    public static void openUrl(String url) {
        instance.driver.get(url);
    }

    public static void exitDriver() {
        instance.driver.quit();
    }

    public static void refreshPage() {
        instance.driver.navigate().refresh();
    }

    public static void switchToLastHandle() {
        Set<String> windowHandles = instance.driver.getWindowHandles();
        instance.driver.switchTo().window(windowHandles.toArray()[getWindowHandlesCount() - LAST_WIDOW_HANDLE_NUMBER].toString());
    }

    public static void switchToDefaultContent() {
        Set<String> windowHandles = instance.driver.getWindowHandles();
        instance.driver.switchTo().window(windowHandles.toArray()[FIRST_WIDOW_HANDLE_NUMBER].toString());
    }

    public static void closeTab() {
        instance.driver.close();
    }

    public static int getWindowHandlesCount() {
        return instance.driver.getWindowHandles().size();
    }
}
