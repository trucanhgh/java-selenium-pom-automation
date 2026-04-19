package Driver;

public class EdgeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        this.driver = new org.openqa.selenium.edge.EdgeDriver();
    }
}
