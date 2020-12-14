package browserFactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class OptionsFactory {
    public Capabilities setOptions(Browsers browsers) {
        switch (browsers){
            case CHROME:{
                return new ChromeOptions().getChromeOptions();
            }
            case FIREFOX:{
                return new FirefoxOptions().getFirefoxOptions();
            }
            default: {
                return null;
            }
        }
    }
}
