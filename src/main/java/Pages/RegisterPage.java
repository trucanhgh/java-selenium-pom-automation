package Pages;

import Constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends CommonPage {
    //các locator của page: thuộc tính của lớp đối tượng
    private By byInputTaiKhoan = By.id("taiKhoan");
    private By byInputMatKhau = By.id("matKhau");
    private By byInputXacNhanMatKhau = By.id("confirmPassWord");
    private By byInputHoTen = By.id("hoTen");
    private By byInputEmail = By.id("email");
    private By bySubmitBtn = By.xpath("//button[@type=\"submit\"]");

    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //các method của page: hành động của người dùng trên page
    public void inputTaiKhoan(String username, long timeoutInSeconds) {
        inputText(byInputTaiKhoan, username, timeoutInSeconds);
    }

    public void inputTaiKhoan(String username) {
        inputTaiKhoan(username, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void inputMatKhau(String password) {
        inputText(byInputMatKhau, password);
    }

    public void inputMatKhau(String password, long timeoutInSeconds) {
        inputText(byInputMatKhau, password, timeoutInSeconds);
    }

    public void inputXacNhanMatKhau(String confirmPassword) {
        inputText(byInputXacNhanMatKhau, confirmPassword);
    }

    public void inputXacNhanMatKhau(String confirmPassword, long timeoutInSeconds) {
        inputText(byInputXacNhanMatKhau, confirmPassword, timeoutInSeconds);
    }

    public void inputHoTen(String fullName) {
        inputText(byInputHoTen, fullName);
    }

    public void inputHoTen(String fullName, long timeoutInSeconds) {
        inputText(byInputHoTen, fullName, timeoutInSeconds);
    }

    public void inputEmail(String email) {
        inputText(byInputEmail, email);
    }

    public void inputEmail(String email, long timeoutInSeconds) {
        inputText(byInputEmail, email, timeoutInSeconds);
    }

    public void clickSubmitBtn() {
        clickBtn(bySubmitBtn);
    }

    public void clickSubmitBtn(long timeoutInSeconds) {
        clickBtn(bySubmitBtn, timeoutInSeconds);
    }


}
