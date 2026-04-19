package Driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    //race condition
    private static ThreadLocal<WebDriver> driverThreatLocal = new ThreadLocal<>();

    //ThreadLocal: mỗi thread sẽ có mọto bản sao của biến này
    //đảm bảo rằng mỗi thread sẽ có một instance riêng của WebDriver, tránh xung đột khi chạy song song

    public static WebDriver getDriverThreadLocal() {
        return driverThreatLocal.get();
    }

    public static void setDriverThreadLocal(WebDriver driver) {
        driverThreatLocal.set(driver);
    }

    public static void removerDriverThreadLocal(){
        driverThreatLocal.remove();
    }
}
