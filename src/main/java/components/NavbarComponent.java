package components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavbarComponent extends BasePage {
    private By byBtnLogin = By.xpath("//h3[text()=\"Đăng Nhập\"]");
    private By byBtnRegister = By.xpath("//h3[text()=\"Đăng Ký\"]");

    public NavbarComponent(WebDriver driver){
        super(driver);
    }

    public void NavigateToLoginPage(){
        clickBtn(byBtnLogin);
    }

    public void NavigateToRegisterPage(){
        clickBtn(byBtnRegister);
    }

}