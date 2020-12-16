package pages.elements;

import elements.Button;
import org.openqa.selenium.By;

public class GamesSubMenu {
    private final Button actionButton = new Button(By.xpath("//a[contains(text(),'Action')]"), "Action button");

    public void clickActionButton() {
        actionButton.click();
    }
}
