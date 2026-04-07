package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    //các locator của page: thuộc tính của lớp đối tượng
    private By byInputTaiKhoan = By.id("taiKhoan");
    private By byInputMatKhau = By.id("matKhau");
    private By byInputXacNhanMatKhau = By.id("confirmPassWord");
    private By byInputHoTen = By.id("hoTen");
    private By byInputEmail = By.id("email");
    private By bySubmitBtn = By.xpath("//button[@type=\"submit\"]");

    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //các method của page: hành động của người dùng trên page
    public void inputTaiKhoan(String username) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputTaiKhoan));
        WebElement txtTaiKhoan = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputTaiKhoan));
        txtTaiKhoan.sendKeys(username);
    }

    public void inputMatKhau(String password) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputMatKhau));
        WebElement txtMatKhau = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputMatKhau));
        txtMatKhau.sendKeys(password);
    }

    public void inputXacNhanMatKhau(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputXacNhanMatKhau));
        WebElement txtXacNhanMatKhau = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputXacNhanMatKhau));
        txtXacNhanMatKhau.sendKeys(confirmPassword);
    }

    public void inputHoTen(String fullName) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputHoTen));
        WebElement txtHoTen = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputHoTen));
        txtHoTen.sendKeys(fullName);
    }

    public void inputEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputEmail));
        WebElement txtEmail = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(byInputEmail));
        txtEmail.sendKeys(email);
    }

    public void clickSubmitBtn() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(bySubmitBtn));
        WebElement submitBtn = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(bySubmitBtn));
        submitBtn.click();
    }


}
