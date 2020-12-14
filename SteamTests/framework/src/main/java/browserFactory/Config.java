package browserFactory;

public class Config {
    private String browser;
    private String server;
    private String resource;
    private String path;
    private String localization;
    private int waitingTime;
    private String apiUrl;
    private String protocol;

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
