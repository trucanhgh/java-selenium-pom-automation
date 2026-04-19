package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // mỗi thread 1 ExtentTest
    private static final String REPORT_PATH = "test-output/ExtentReport_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hh_mm_ss")) + ".html";
    private static final String SCREENSHOT_PATH = "test-output/screenshots/";

    public static void initializeExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    public static void createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    private static ExtentTest getTest() {
        return test.get();
    }

    public static void info(String msg) {
        getTest().info(msg);
    }

    public static void pass(String msg) {
        getTest().pass(msg);
    }

    public static void fail(String msg) {
        getTest().fail(msg);
    }

    public static void captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            fail("Could not capture screenshot: driver is null.");
            return;
        }
        if (!(driver instanceof TakesScreenshot)) {
            fail("Could not capture screenshot: driver does not support screenshots.");
            return;
        }

        // Ensure screenshot folder exists before writing image files.
        File destFolder = new File(SCREENSHOT_PATH);
        if (!destFolder.exists() && !destFolder.mkdirs()) {
            fail("Could not capture screenshot: failed to create screenshot folder.");
            return;
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String safeTestName = (testName == null || testName.trim().isEmpty()) ? "test" : testName.trim();
        String fileName = safeTestName + "_" + timestamp + ".png";
        File destFile = new File(SCREENSHOT_PATH + fileName);

        try {
            Files.copy(sourceFile, destFile);
            String relativePath = "screenshots/" + fileName;
            getTest().fail("Screenshot captured", MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void flushReports() {
        if(extent != null) {
            extent.flush();
        }
    }
}