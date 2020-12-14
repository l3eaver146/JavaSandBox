package testSteps;

import browserFactory.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import logger.Logger;

public class Hooks {
    @Before
    public void setUp() {
        Browser.getInstance().manage().window().maximize();
        Logger.debug("Setup complited");
    }

    @After
    public void closeApplication() {
        Logger.debug("Closing driver");
        Browser.exitDriver();
    }

}
