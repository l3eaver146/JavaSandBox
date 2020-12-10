package pages;

import elements.Button;
import org.openqa.selenium.By;
import waitUtil.WaitUtil;

public class InstallationPage {
    private final Button installSteamButton = new Button(By.xpath("//a[@class='about_install_steam_link']"), "Install steam button");

    public Button getInstallSteamButton() {
        return installSteamButton;
    }

    public boolean isInstallationPageOpened() {
        WaitUtil.waitForClickable(installSteamButton);
        return installSteamButton.isVisible();
    }
}
