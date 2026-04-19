package Base;

import Driver.DriverFactory;
import Driver.DriverManager;
import Driver.ChromeDriverManager;
import ExtentReport.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

public class BaseTest {

    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("Starting test suite execution...");
        //khowir taoj report
        ExtentReportManager.initializeExtentReports();
    }
    @BeforeClass
    public void beforeClass() {
        LOG.info("Starting before class setup...");
        //khởi taoj chrome driver
        DriverManager driverManager = new ChromeDriverManager();
        driverManager.createWebDriver();
        //lấy driver từ driver manager và set vào thredlocal
        WebDriver driver = driverManager.getDriver();
        DriverFactory.setDriverThreadLocal(driver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG.info("Starting test method: " + method.getName());
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if(testResult.getStatus() == ITestResult.FAILURE){
            ExtentReportManager.captureScreenshot(
                    DriverFactory.getDriverThreadLocal(),
                    testResult.getMethod().getMethodName()
            );
            //ghi log lỗi vào report
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
    }

    @AfterClass
    public void afterClass() {
        WebDriver driver = DriverFactory.getDriverThreadLocal();
        if (driver != null) {
            driver.quit();
            DriverFactory.setDriverThreadLocal(null);
            //... xóa driver khỏi thread local ...
        }
    }

    @AfterSuite
    public void afterSuite() {
        //kết  thúc report
        ExtentReportManager.flushReports();
    }
}
