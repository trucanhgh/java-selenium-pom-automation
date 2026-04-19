package Driver;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String browser) {
        DriverManager driverManager;
        switch (browser) {
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            case "edge":
                driverManager = new EdgeDriverManager();
                break;
            case "safari":
                driverManager = new SafariDriverManager();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
        return driverManager;
    }
}
