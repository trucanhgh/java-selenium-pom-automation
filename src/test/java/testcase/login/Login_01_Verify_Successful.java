package testcase.login;

import Driver.DriverFactory;
import Pages.CommonDialog;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_01_Verify_Successful extends Base.BaseTest {
    @Test(description = "Verify that user can login successfully with valid credentials")
    public void testValidLogin() {
        String username = "testing141";
        String password = "Carson2309";

        WebDriver driver = DriverFactory.getDriverThreadLocal();
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");
        //khởi tạo page
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CommonDialog commonDialog = new CommonDialog(driver);

        //truy cập vào login page
        homePage.getNavbarComponent().NavigateToLoginPage();
        //nhập dữ liệu
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();

        //verify login thành công bằng cách kiểm tra sự tồn tại của element trên home page sau khi login thành công
        String recordMessageLogin = commonDialog.getTitleDialog();
        Assert.assertEquals(recordMessageLogin, "Đăng nhập thành công");
    }

}
