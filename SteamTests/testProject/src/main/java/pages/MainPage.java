package pages;

import elements.Button;
import org.openqa.selenium.By;
import pages.elements.GamesSubMenu;
import waitUtil.WaitUtil;

public class MainPage {
    private Button installButton = new Button(By.xpath("//div[contains(@class,'header_installsteam_btn')]"), "Install steam button");
    private Button browseButton = new Button(By.xpath("//a[@href='https://store.steampowered.com/games/?snr=1_4_4__12']/following-sibling::span"), "Browse button");
    private GamesSubMenu gamesSubMenu = new GamesSubMenu();

    public boolean isMainPageOpened() {
        WaitUtil.waitForClickable(installButton);
        return installButton.isVisible();
    }

    public void clickInstallButton() {
        installButton.click();
    }

    public void clickBrowseButton() {
        WaitUtil.waitForDisplayed(browseButton);
        browseButton.click();
    }

    public GamesSubMenu getGamesSubMenu() {
        return gamesSubMenu;
    }
}
