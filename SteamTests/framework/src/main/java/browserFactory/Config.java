package browserFactory;

public class Config {
    private final String browser;
    private final String server;
    private final String resource;
    private final String path;
    private final String localization;
    private final int waitingTime;
    private final String apiUrl;
    private final String protocol;

    public Config(String browser, String server, String resource, String path, String localization, int waitingTime, String apiUrl, String protocol) {
        this.apiUrl = apiUrl;
        this.localization = localization;
        this.browser = browser;
        this.server = server;
        this.resource = resource;
        this.path = path;
        this.waitingTime = waitingTime;
        this.protocol = protocol;
    }

    public Config() {
        this.apiUrl = null;
        this.localization = null;
        this.browser = null;
        this.server = null;
        this.resource = null;
        this.path = null;
        this.waitingTime = 0;
        this.protocol = null;
    }

    public String getBrowser() {
        return browser;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getLocalization() {
        return localization;
    }

    public String getServer() {
        return server;
    }

    public String getPath() {
        return path;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public String getResource() {
        return resource;
    }
}
