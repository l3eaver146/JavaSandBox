package pages;

import elements.Button;
import elements.TabList;
import elements.Text;
import helpers.GameListHelper;
import models.GameDataModel;
import org.openqa.selenium.By;
import waitUtil.WaitUtil;

public class ActionGamesPage {
    private final Button topSellersButton = new Button(By.xpath("//div[@id='tab_select_TopSellers']"), "TopSellers button");
    private final Text pageHeader = new Text(By.cssSelector("h2.pageheader"), "Page header");
    private final TabList gamesTabList = new TabList(By.xpath(".//div[@id='TopSellersRows']/a"), "Games tab list");

    public boolean isMainPageOpened() {
        WaitUtil.waitForDisplayed(pageHeader);
        return pageHeader.getInnerText().contains("Action");
    }

    public Button getTopSellersButton() {
        return topSellersButton;
    }

    public GameDataModel getDataAndClickSpecificGameButton() {
        WaitUtil.waitForClickable(gamesTabList);
        GameDataModel gameData = GameListHelper.clickGameBlockWithMaximalDiscount(gamesTabList.getComponents());
        return gameData;
    }
}
