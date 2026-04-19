package Pages;

import Constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonPage {
    private By byUsername = By.id("taiKhoan");
    private By byPassword = By.id("matKhau");
    private By byLoginBtn = By.xpath("//span[text()=\"Đăng nhập\"]");

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        inputText(byUsername, username);
    }

    public void inputUsername(String username, long timeoutInSeconds) {
        inputText(byUsername, username, timeoutInSeconds);
    }

    public void inputPassword(String password) {
        inputText(byPassword, password);
    }

    public void inputPassword(String password, long timeoutInSeconds) {
        inputText(byPassword, password, timeoutInSeconds);
    }

    public void clickLoginBtn() {
        clickBtn(byLoginBtn);
    }

    public void clickLoginBtn(long timeoutInSeconds) {
        clickBtn(byLoginBtn, timeoutInSeconds);
    }



}
