package pages.elements;

import browserFactory.BrowserOptions;
import elements.Button;
import org.openqa.selenium.By;
import waitUtil.WaitUtil;

public class GamesSubMenu {
    private Button actionButton = generateActionButtonLocator();

    private Button generateActionButtonLocator() {
        if (BrowserOptions.getSettings().getLocalization().equals("en"))
            return new Button(By.xpath("//*[@id='genre_flyout']/div/div[2]/a[1]"), "Action button");
        else
            return new Button(By.xpath("//*[@id='genre_flyout']/div/div[2]/a[10]"), "Action button");
    }

    public Button getActionButton() {
        WaitUtil.waitForClickable(actionButton);
        return actionButton;
    }
}
