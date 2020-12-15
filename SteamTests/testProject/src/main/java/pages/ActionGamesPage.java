package pages;

import elements.Button;
import org.openqa.selenium.By;
import pages.elements.GameBlockListForm;

public class ActionGamesPage extends Page {
    public ActionGamesPage() {
        super(By.xpath("//h2[contains(text(),'Browsing Action')]"), "Action games page");
    }

    private final Button topSellersButton = new Button(By.xpath("//div[@id='tab_select_TopSellers']"), "TopSellers button");

    public GameBlockListForm getGameBlockList() {
        return new GameBlockListForm();
    }

    public void clickTopSellersButton() {
        topSellersButton.click();
    }
}
