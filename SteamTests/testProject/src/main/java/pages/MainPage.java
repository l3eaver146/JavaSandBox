package pages;

import elements.Button;
import org.openqa.selenium.By;
import pages.elements.GamesSubMenu;

public class MainPage extends Page {
    public MainPage() {
        super(By.xpath("//h1[contains(text(),'The Community Recommends')]"), "Main page");
    }

    private final Button browseButton = new Button(By.xpath("//a[@class='pulldown_mobile']/following-sibling::span"), "Browse button");
    private final GamesSubMenu gamesSubMenu = new GamesSubMenu();

    public void clickBrowseButton() {
        browseButton.click();
    }

    public GamesSubMenu getGamesSubMenu() {
        return gamesSubMenu;
    }
}
