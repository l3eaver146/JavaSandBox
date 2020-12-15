package pages;

import elements.Button;
import org.openqa.selenium.By;

public class InstallationPage extends Page {
    public InstallationPage() {
        super(By.xpath("//div[contains(text(),'Steam is the ultimate destination for playing, discussing, and creating games.')]"), "Installation page");
    }

    private final Button btnInstallSteam = new Button(By.xpath("//a[@class='about_install_steam_link']"), "Install steam button");

    public void clickInstallSteamButton() {
        btnInstallSteam.click();
    }
}
