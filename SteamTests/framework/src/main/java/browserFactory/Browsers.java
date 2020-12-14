package browserFactory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox");
    private final String title;

    public static Browsers getByName(String name) {
        for (Browsers browser : Browsers.values()) {
            if (browser.title.equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }
}
