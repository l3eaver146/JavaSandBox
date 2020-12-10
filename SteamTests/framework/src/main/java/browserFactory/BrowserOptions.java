package browserFactory;

import fileUtil.FileUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserOptions {

    private static final String downloadDirectoryPath = "\\framework\\src\\main\\resources\\";
    private static final Config settings = FileUtil.getFrameworkConfig();

    public static String getApplicationUrl() {
        return settings.getProtocol() + settings.getServer() + settings.getResource();
    }

    public static String getDownloadDirectoryPath() {
        return FileUtil.getPathToProjFolder() + downloadDirectoryPath;
    }

    public static Config getSettings() {
        return settings;
    }

    private static ChromeOptions getChromeOptions() {
        String fullPath = FileUtil.getPathToProjFolder() + downloadDirectoryPath;
        ChromeOptions chromeConfig = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", fullPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.extensions_to_open", "application/xml");
        prefs.put("safebrowsing.enabled", true);
        chromeConfig.setExperimentalOption("prefs", prefs);
        chromeConfig.setCapability("intl.accept_languages", settings.getLocalization());
        chromeConfig.addArguments("--safebrowsing-disable-download-protection");
        chromeConfig.addArguments("safebrowsing-disable-extension-blacklist");
        return chromeConfig;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions profile = new FirefoxOptions();
        profile.setCapability("browser.download.folderList", 2);
        profile.setCapability("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        profile.setCapability("intl.accept_languages", settings.getLocalization());
        return profile;
    }

    public static WebDriver configFireFoxBrowser() {
        return new FirefoxDriver(getFirefoxOptions());
    }

    public static WebDriver configChromeBrowser() {
        return new ChromeDriver(getChromeOptions());
    }
}
