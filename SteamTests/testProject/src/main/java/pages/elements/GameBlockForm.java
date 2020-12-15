package pages.elements;

import browserFactory.Browser;
import helpers.LocParts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GameBlockForm extends GameBlockListForm {
    private static final int ELEMENT_INDEX = 0;

    protected GameBlockForm(int index) {
        blockLocator = By.xpath(String.format("//div[@id='TopSellersRows']//a[%s]", index));
    }

    private final String LOC_FIELD = "div.%s";
    protected By blockLocator;

    public String getFieldValue(LocParts locPart) {
        WebElement element = (WebElement) getElement()
                .findElements(By.cssSelector(String.format(LOC_FIELD, locPart.getTitle())))
                .toArray()[ELEMENT_INDEX];
        return element.getAttribute("innerHTML");
    }

    private WebElement getElement() {
        return Browser.getInstance().getDriver().findElement(blockLocator);
    }
}
