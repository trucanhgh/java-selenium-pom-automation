package Driver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        this.driver = new org.openqa.selenium.firefox.FirefoxDriver();
    }
}
