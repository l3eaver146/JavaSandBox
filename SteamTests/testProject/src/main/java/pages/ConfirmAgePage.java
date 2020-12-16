package pages;

import elements.Button;
import org.openqa.selenium.By;

public class ConfirmAgePage extends Page {
    public ConfirmAgePage() {
        super(By.xpath("//h2[contains(text(),'This Game may contain content not appropriate for all ages')]"), " Age page");
    }

    private final Button btnYear = new Button(By.xpath("//select[@name='ageYear']"), "Year button");
    private final Button btnViewPage = new Button(By.xpath("//div[contains(@class,'agegate_text_container')]//a[contains(@class,'btnv6_blue_hoverfade')]"), "View page button");
    private final Button btnSpecificYear = new Button(By.xpath("//option[@value = 2000]"), "2000 year button");

    public void abuseAgeControl() {
        btnYear.click();
        btnSpecificYear.click();
        btnViewPage.click();
        btnViewPage.waitForDisappear();
    }
}
