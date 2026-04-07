package testcase.register;

import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.UUID;

public class Register_01_Verify_Successful {

    //assert -> hard assert và soft assert

    @Test(description = "Verify user can register successfully with valid data")
    public void verifySuccessfulRegister() throws InterruptedException {
        //b1: khởi tạo web driver và chrome option
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //b2: đi tới trang web https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //tạo dữ liệu ngẫu nhiên
        String account = UUID.randomUUID().toString();
        String email = account + "@gmail.com";

        //b3: ấn nút đăng ký
        By byRegisterBtn = By.xpath("//h3[text()=\"Đăng Ký\"]");
        WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(byRegisterBtn));
        registerBtn.click();

        //b4: nhập thông tin đăng ký hợp lệ
        RegisterPage register = new RegisterPage(driver);
        register.inputTaiKhoan(account);
        register.inputMatKhau("Test123@");
        register.inputXacNhanMatKhau("Test123@");
        register.inputHoTen("Test Register");
        register.inputEmail(email);
        register.clickSubmitBtn();

        //VP1(Verified point): Kiểm tra đnawg ký thành công
        By byLBLSuccess = By.id("swal2-title");
        WebElement lblSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLBLSuccess));

        String recordMessage = lblSuccess.getText();

        //HARD ASSERT
        //expected: giá trị mong đợi(đã đc định nghĩa trc)
        //mesage: thông báo khi TC thất bại
        Assert.assertEquals(recordMessage, "Đăng ký thành công", "VP1: Đăng ký thất bại - MESSAGE DOES NOT MATCH");

        //SOFT ASSERT
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(recordMessage, "Đăng ký thành công", "VP1: Đăng ký thất bại - MESSAGE DOES NOT MATCH");
        //lưu ý bắt buộc phải đóng ở cuối để tổng hợp kế quả (QUAN TRỌNG)
        softAssert.assertAll();

        By byCloseAlert = By.xpath("//button[text()=\"Đóng\"]");
        WebElement closeAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(byCloseAlert));
        closeAlert.click();

        //VP2: Kiểm tra đăng nhập thành công sau khi đăng ký
        By byLoginBtn = By.xpath("//h3[text()=\"Đăng Nhập\"]");
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn));
        loginBtn.click();

        LoginPage login = new LoginPage(driver);
        login.inputUsername(account);
        login.inputPassword("Test123@");
        login.clickLoginBtn();

        By byLoginSuccess = By.id("swal2-title");
        WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginSuccess));
        String recordLoginMessage = lblLoginSuccess.getText();

        Assert.assertEquals(recordLoginMessage, "Đăng nhập thành công", "VP2: Đăng nhập thất bại - MESSAGE DOES NOT MATCH");


        driver.quit();

    }

//    @Test(description = "Verify user cannot register with existing account")
//    public void verifyRegisterWithExistingAccount() throws InterruptedException {
//        //testcase đăng ký thất bại
//    }

}
