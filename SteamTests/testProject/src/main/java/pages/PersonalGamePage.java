package pages;

import elements.Button;
import elements.Text;
import models.GameDataModel;
import org.openqa.selenium.By;
import waitUtil.WaitUtil;

public class PersonalGamePage {
    private final Text header = new Text(By.xpath("//div[@class='apphub_AppName']"), "Header");
    private final Text discountPrice = new Text(By.cssSelector("div.discount_final_price"), "Discount price");
    private final Text price = new Text(By.xpath("//div[@class='discount_original_price']"), "Price");
    private final Text discount = new Text(By.xpath("//div[@class='discount_pct']"), "Discount");
    private final Button communityHubButton = new Button(By.xpath("//a[@class='btnv6_blue_hoverfade btn_medium']"), "Community hub button");
    private final Button installButton = new Button(By.xpath("//div[contains(@class,'header_installsteam_btn')]"), "Install steam button");

    public GameDataModel getAllGameInfo() {
        WaitUtil.waitForClickable(discount);
        String finalPrice = discountPrice.getInnerText();
        String discountValue = discount.getInnerText();
        return new GameDataModel(
                price.getInnerText(),
                discountValue.substring(1, discountValue.length() - 1),
                finalPrice.substring(0, finalPrice.length() - 4),
                header.getInnerText()
        );
    }

    public boolean isPageOpened() {
        WaitUtil.waitForClickable(communityHubButton);
        return communityHubButton.isVisible();
    }

    public Button getInstallButton() {
        return installButton;
    }
}
