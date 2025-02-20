package khims.rodion.driver;

import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class SeleniumDriver {
    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @Setter
    private static ChromeOptions options;

    public static WebDriver getInstance() {
        if (Objects.isNull(driver.get())) {
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }
}
