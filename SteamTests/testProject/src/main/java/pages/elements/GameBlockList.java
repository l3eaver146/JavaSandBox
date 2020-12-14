package pages.elements;

import browserFactory.Browser;
import logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameBlockList {
    private final By gameLocator = By.xpath("//div[@id='TopSellersRows']//a//div[@class='discount_pct']//ancestor::a");
    private final By discountLocator = By.xpath("//div[@id='TopSellersTable']//div[@class='discount_pct']");
    private final int SUBSTRING_RANGE_VALUE = 1;
    private GameBlock gameBlock;

    public GameBlock getGameBlock() {
        return gameBlock;
    }

    public int getIndexOfGameBlockWithMaxDiscount() {
        List<WebElement> discounts = Browser.getInstance().findElements(discountLocator);
        if (discounts.size() == 0){
            Logger.info("No games with discount today!");
            System.exit(0);
        }
        List<Integer> discountValues = discounts.stream()
                .map(element -> Integer.parseInt(element.getText().substring(SUBSTRING_RANGE_VALUE, element.getText().length() - SUBSTRING_RANGE_VALUE)))
                .collect(Collectors.toList());
        int index = discountValues.indexOf(Collections.max(discountValues));
        return index;
    }

    public void findBlockWithMaxDiscount(int index) {
        List<WebElement> blocks = Browser.getInstance().findElements(gameLocator);
        gameBlock = new GameBlock(blocks.get(index));
    }

    public void clickOnGameBlock() {
        findBlockWithMaxDiscount(getIndexOfGameBlockWithMaxDiscount());
        gameBlock.click();
    }
}
