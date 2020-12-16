package testSteps;

import browserFactory.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import logger.Logger;

public class Hooks {
    @Before
    public void setUp() {
        Browser.getInstance().getDriver().manage().window().maximize();
        Logger.info("Setup complited");
    }

    @After
    public void closeApplication() {
        Logger.info("Closing driver");
        Browser.getInstance().exitDriver();
    }
}
