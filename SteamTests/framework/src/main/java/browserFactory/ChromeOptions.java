package browserFactory;

import fileUtil.FileUtil;

import java.util.HashMap;
import java.util.Map;

public class ChromeOptions {
    public org.openqa.selenium.chrome.ChromeOptions getChromeOptions() {
        return setArguments(setCapabilities(setPreferences()));
    }

    private org.openqa.selenium.chrome.ChromeOptions setCapabilities(org.openqa.selenium.chrome.ChromeOptions chromeConfig) {
        chromeConfig.setCapability("intl.accept_languages", FileUtil.getFrameworkConfig().getLocalization());
        return chromeConfig;
    }

    private org.openqa.selenium.chrome.ChromeOptions setPreferences() {
        String fullPath = FileUtil.getPathToDownloadDirectory();
        org.openqa.selenium.chrome.ChromeOptions chromeConfig = new org.openqa.selenium.chrome.ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", fullPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.extensions_to_open", "application/xml");
        prefs.put("safebrowsing.enabled", true);
        chromeConfig.setExperimentalOption("prefs", prefs);
        return chromeConfig;
    }

    private org.openqa.selenium.chrome.ChromeOptions setArguments(org.openqa.selenium.chrome.ChromeOptions chromeConfig) {
        chromeConfig.addArguments("--safebrowsing-disable-download-protection");
        chromeConfig.addArguments("safebrowsing-disable-extension-blacklist");
        return chromeConfig;
    }
}
