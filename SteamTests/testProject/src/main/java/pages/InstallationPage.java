package pages;

import org.openqa.selenium.By;

public class InstallationPage extends Page {
    public InstallationPage() {
        super(By.xpath("//div[contains(text(),'Steam is the ultimate destination for playing, discussing, and creating games.')]"), "Installation page");
    }

    public void clickInstallSteamButton() {
        installButton.click();
    }
}
