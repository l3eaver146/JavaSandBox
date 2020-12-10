package elements;

import browserFactory.Browser;
import logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;

public abstract class BaseElement {
    private final String name;
    private final By locator;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public By getLocator() {
        return this.locator;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVisible() {
        try {
            boolean result = Browser.getDriver().findElement(locator).isDisplayed()
                    &&
                    isElementExists();
            Logger.debug("Element " + name + "is visible : " + result);
            return result;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    private boolean isElementExists() {
        return Browser.getDriver().findElements(locator).size() > 0;
    }

    public void click() {
        Logger.debug("Click " + name);
        try {
            Browser.getDriver().findElement(locator).click();
        } catch (ElementClickInterceptedException exception) {
            Logger.error(exception.getMessage());
        } catch (NoSuchElementException exception) {
            Logger.error(exception.getMessage());
            Browser.getDriver().findElement(locator).click();
        }
    }

    public String getValue(String parentTag) {
        return Browser.getDriver().findElement(By.xpath(parentTag)).getAttribute("value");
    }

    public String getInnerText() {
        Logger.debug("Get inner text of " + name);
        return Browser.getDriver().findElement(locator).getText();
    }
}
