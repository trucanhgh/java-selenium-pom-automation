package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By byUsername = By.id("taiKhoan");
    private By byPassword = By.id("matKhau");
    private By byLoginBtn = By.xpath("//span[text()=\"Đăng nhập\"]");

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        driver.findElement(byUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(byPassword).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(byLoginBtn).click();
    }



}
