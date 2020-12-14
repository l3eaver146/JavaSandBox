package pages;

import elements.Button;
import org.openqa.selenium.By;
import pages.elements.GameBlockList;

public class ActionGamesPage extends Page {
    public ActionGamesPage() {
        super(By.xpath("//h2[contains(text(),'Browsing Action')]"), "Action games page");
    }

    private final Button topSellersButton = new Button(By.xpath("//div[@id='tab_select_TopSellers']"), "TopSellers button");
    private final GameBlockList gameBlockList = new GameBlockList();

    public GameBlockList getGameBlockList() {
        return gameBlockList;
    }

    public void clickTopSellersButton() {
        topSellersButton.click();
    }
}
