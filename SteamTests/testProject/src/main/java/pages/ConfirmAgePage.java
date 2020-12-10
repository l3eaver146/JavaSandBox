package pages;

import elements.Button;
import org.openqa.selenium.By;
import waitUtil.WaitUtil;

public class ConfirmAgePage {
    private final Button yearButton = new Button(By.xpath("//select[@name='ageYear']"), "Year button");
    private final Button viewPageButton = new Button(By.xpath("//a[@class='btnv6_blue_hoverfade btn_medium']"), "View page button");
    private final Button specificYearButton = new Button(By.xpath("//option[@value = 2000]"), "2000 year button");

    public void abuseAgeControl() {
        WaitUtil.waitForDisplayed(yearButton);
        yearButton.click();
        WaitUtil.waitForDisplayed(specificYearButton);
        specificYearButton.click();
        viewPageButton.click();
    }

    public boolean isPageOpened() {
        return yearButton.isVisible();
    }
}
