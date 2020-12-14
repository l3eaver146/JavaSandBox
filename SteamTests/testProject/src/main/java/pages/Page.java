package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public abstract class Page {
    protected final Button installButton = new Button(By.xpath("//div[contains(@class,'header_installsteam_btn')]"), "Install steam button");
    protected final By locator;
    protected final String name;

    protected Page(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void clickInstallButton() {
        installButton.click();
    }

    public boolean isPageOpened() {
        Label lblPage = new Label(this.locator,this.name + " unique element");
        return lblPage.isVisible();
    }
}
