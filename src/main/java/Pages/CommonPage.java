package Pages;

import Base.BasePage;
import components.FooterComponent;
import components.NavbarComponent;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {
    private NavbarComponent navbarComponent;
    private FooterComponent footerComponent;

    // Constructor
    public CommonPage (WebDriver driver) {
        super(driver);
        this.navbarComponent = new NavbarComponent(driver);
        this.footerComponent = new FooterComponent();
    }

    // Getters for components
    public NavbarComponent getNavbarComponent() {
        return navbarComponent;
    }

    public FooterComponent getFooterComponent() {
        return footerComponent;
    }
}

