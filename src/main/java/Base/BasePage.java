package Base;

import Constants.TimeOutConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    // các thuộc tính
    protected final Logger LOG = (Logger) LogManager.getLogger(getClass());
    protected WebDriver driver;

    // constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // các method
    public WebElement waitForElementClickable(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public void inputText(By locator, String value, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(value);
    }

    public void inputText(By locator, String value) {
        inputText(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clickBtn(By locator, long timeoutInSeconds) {
        LOG.info("Click button with locator: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeoutInSeconds));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public void clickBtn(By locator) {
        clickBtn(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public String getTextElement(By locator, long timeOutInSec) {
        WebElement element = waitForElementVisible(locator, timeOutInSec);
        return element.getText();
    }

    public WebElement waitForElementVisible(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public String getTextElement(By locator) {
        return getTextElement(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }
}