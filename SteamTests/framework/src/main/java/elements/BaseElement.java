package elements;

import browserFactory.Browser;
import logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waitUtil.WaitUtil;

public abstract class BaseElement {
    private final String name;
    private final By locator;
    private final static org.apache.log4j.Logger logger = Logger.getLogger();

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
            this.waitForDisplayed();
            Logger.debug("Element " + name + "is visible : " + true);
            return true;
        } catch (NoSuchElementException exception) {
            Logger.error(exception.getMessage());
            Logger.error(String.format("Element %s wasn't found", name));
            return false;
        } catch (TimeoutException exception) {
            Logger.error(exception.getMessage());
            return false;
        }
    }

    private boolean isElementExists() {
        return Browser.getInstance().findElements(locator).size() > 0;
    }

    public void click() {
        waitForDisplayed();
        this.waitForClickable();
        Logger.debug("Click " + name);
        try {
            Browser.getInstance().findElement(locator).click();
        } catch (NoSuchElementException exception) {
            Logger.error(exception.getMessage());
            Logger.error(String.format("Element %s wasn't found", name));
            Browser.getInstance().findElement(locator).click();
        }
    }

    public void exceptionClick() {
        this.waitForClickable();
        Logger.debug("Click " + name);
        try {
            Browser.getInstance().findElement(locator).click();
        } catch (ElementClickInterceptedException exception) {
            Logger.error(exception.getMessage());
        } catch (NoSuchElementException exception) {
            Logger.error(exception.getMessage());
            Browser.getInstance().findElement(locator).click();
        }
    }

    public String getAttributeValue(String parentTag, String attributeName) {
        return Browser.getInstance().findElement(By.xpath(parentTag)).getAttribute(attributeName);
    }

    public String getText() {
        try {
            this.waitForDisplayed();
            Logger.debug("Get inner text of " + name);
            return Browser.getInstance().findElement(locator).getText();
        } catch (TimeoutException exception) {
            Logger.error(exception.getMessage());
        }
        return Browser.getInstance().findElement(locator).getText();
    }

    public void waitForClickable() {
        Logger.debug("Waiting for clickable : " + this.getName());
        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), WaitUtil.getWaitingTime());
        wait.until(ExpectedConditions.elementToBeClickable(this.getLocator()));
    }

    public void waitForDisplayed() {
        Logger.debug("Waiting for displayed : " + this.getName());
        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), WaitUtil.getWaitingTime());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.getLocator()));
    }
}
