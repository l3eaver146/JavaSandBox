package pages.elements;

import elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GameBlock {
    private final WebElement current;
    private final Text discount = new Text(By.cssSelector("div.discount_pct"), "Game discount");
    private final Text name = new Text(By.cssSelector("div.tab_item_name"), "Game name");
    private final Text price = new Text(By.cssSelector("div.discount_original_price"), "Game price");
    private final Text discountFinalPrice = new Text(By.cssSelector("div.discount_final_price"), "Final price");

    public GameBlock(WebElement element) {
        current = element;
    }

    public WebElement getCurrent() {
        return current;
    }

    public String getDiscount() {
        List<WebElement> webElements = current.findElements(discount.getLocator());
        if (webElements.size() > 0) {
            WebElement element = (WebElement) webElements.toArray()[0];
            String text = element.getText();
            return text.substring(1, 3);
        }
        return null;
    }

    public String getPrice() {
        WebElement element = (WebElement) current.findElements(price.getLocator()).toArray()[0];
        return element.getAttribute("innerHTML");
    }

    public String getName() {
        WebElement element = (WebElement) current.findElements(name.getLocator()).toArray()[0];
        return element.getAttribute("innerHTML");
    }

    public String getDiscountFinalPrice() {
        WebElement element = (WebElement) current.findElements(discountFinalPrice.getLocator()).toArray()[0];
        return element.getAttribute("innerHTML");
    }
}
