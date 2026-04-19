package Driver;

public class SafariDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        this.driver = new org.openqa.selenium.safari.SafariDriver();
    }
}
