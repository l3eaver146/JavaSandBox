package pages.elements;

import elements.Label;
import models.GameDataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GameBlock {
    public GameBlock(WebElement element) {
        current = element;
    }

    private final WebElement current;
    private final Label discountLabel = new Label(By.cssSelector("div.discount_pct"), "Game discount");
    private final Label nameLabel = new Label(By.cssSelector("div.tab_item_name"), "Game name");
    private final Label priceLabel = new Label(By.cssSelector("div.discount_original_price"), "Game price");
    private final Label discountFinalPriceLabel = new Label(By.cssSelector("div.discount_final_price"), "Final price");
    private final int ELEMENT_INDEX = 0;
    private final int BEGIN_OF_STRING = 1;
    private final int END_OF_STRING = 3;

    public void click() {
        this.current.click();
    }

    private String getDiscount() {
        List<WebElement> webElements = current.findElements(discountLabel.getLocator());
        if (webElements.size() > 0) {
            WebElement element = (WebElement) webElements.toArray()[ELEMENT_INDEX];
            String text = element.getText();
            return text.substring(BEGIN_OF_STRING, END_OF_STRING);
        }
        return null;
    }

    private String getPrice() {
        WebElement element = (WebElement) current.findElements(priceLabel.getLocator()).toArray()[ELEMENT_INDEX];
        return element.getAttribute("innerHTML");
    }

    private String getName() {
        WebElement element = (WebElement) current.findElements(nameLabel.getLocator()).toArray()[ELEMENT_INDEX];
        return element.getAttribute("innerHTML");
    }

    private String getDiscountFinalPrice() {
        WebElement element = (WebElement) current.findElements(discountFinalPriceLabel.getLocator()).toArray()[ELEMENT_INDEX];
        return element.getAttribute("innerHTML");
    }

    public GameDataModel getGameData() {
        return new GameDataModel(
                getPrice(),
                getDiscount(),
                getDiscountFinalPrice(),
                getName()
        );
    }
}
