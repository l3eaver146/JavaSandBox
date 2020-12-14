package pages;

import elements.Button;
import org.openqa.selenium.By;

public class ConfirmAgePage extends Page {
    public ConfirmAgePage() {
        super(By.xpath("//p[text()='“Similar to DOOM from 2016, DOOM Eternal will contain Blood and Gore, Intense Violence and Strong Language”']"), " Age page");
    }

    private final Button yearButton = new Button(By.xpath("//select[@name='ageYear']"), "Year button");
    private final Button viewPageButton = new Button(By.xpath("//a[@class='btnv6_blue_hoverfade btn_medium']"), "View page button");
    private final Button specificYearButton = new Button(By.xpath("//option[@value = 2000]"), "2000 year button");

    public void abuseAgeControl() {
        yearButton.click();
        specificYearButton.click();
        viewPageButton.click();
    }
}
