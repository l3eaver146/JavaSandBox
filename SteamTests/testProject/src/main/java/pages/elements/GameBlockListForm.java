package pages.elements;

import browserFactory.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBlockListForm {
    private static final String LOC_GAME_BLOCK_BY_NAME = "//div[@id='TopSellersRows']//a[.//*[text()='%s']]";
    private final By gameLocator = By.xpath("//div[@id='TopSellersRows']//a");
    private final By discountLocator = By.cssSelector("div.discount_pct");

    public GameBlockForm getGameBlockByNumberInList(int index) {
        return new GameBlockForm(index);
    }

    public int getIndexOfGameWithMaxDiscount() {
        List<WebElement> games = getGameList();
        Map<Integer, Integer> discounts = new HashMap<>();
        int i = 0;
        for (WebElement game : games) {
            if (game.findElements(discountLocator).size() > 0) {
                WebElement discount = game.findElement(discountLocator);
                discounts.put(++i, Integer.parseInt(discount.getText().replace("%", "").replace("-", "").trim()));
            } else {
                discounts.put(++i, 0);
            }
        }
        return discounts.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public void clickBlockByName(String key) {
        By locator = By.xpath(String.format(LOC_GAME_BLOCK_BY_NAME, key));
        Browser.getInstance().getDriver().findElement(locator).click();
    }

    private List<WebElement> getGameList() {
        return Browser.getInstance().getDriver().findElements(gameLocator);
    }
}
