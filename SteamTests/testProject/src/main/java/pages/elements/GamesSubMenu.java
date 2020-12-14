package pages.elements;

import elements.Button;
import fileUtil.FileUtil;
import org.openqa.selenium.By;
import waitUtil.WaitUtil;

public class GamesSubMenu {
    private final Button actionButton = generateActionButtonLocator();

    private Button generateActionButtonLocator() {
        if (FileUtil.getFrameworkConfig().getLocalization().equals("en"))
            return new Button(By.xpath("//*[@id='genre_flyout']/div/div[2]/a[1]"), "Action button");
        else
            return new Button(By.xpath("//*[@id='genre_flyout']/div/div[2]/a[10]"), "Action button");
    }

    public void clickActionButton() {
        actionButton.click();
    }
}
