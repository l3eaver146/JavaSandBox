package pages;

import elements.Button;
import elements.Label;
import models.GameDataModel;
import org.openqa.selenium.By;

public class PersonalGamePage extends Page {
    public PersonalGamePage() {
        super(By.xpath("//h2[text()='System Requirements']"), "Personal game page");
    }

    private final Label header = new Label(By.xpath("//div[@class='apphub_AppName']"), "Header");
    private final Label discountPrice = new Label(By.cssSelector("div.discount_final_price"), "Discount price");
    private final Label price = new Label(By.xpath("//div[@class='discount_original_price']"), "Price");
    private final Label discount = new Label(By.xpath("//div[@class='discount_pct']"), "Discount");

    public GameDataModel getAllGameInfo() {
        String finalPrice = discountPrice.getText();
        String discountValue = discount.getText();
        return new GameDataModel(
                price.getText(),
                discountValue.substring(1, discountValue.length() - 1),
                finalPrice.substring(0, finalPrice.length() - 4),
                header.getText()
        );
    }

    public void clickInstallButton() {
        installButton.click();
    }
}
