package khims.rodion;

import io.github.bonigarcia.wdm.WebDriverManager;
import khims.rodion.driver.SeleniumDriver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        SeleniumDriver.setOptions(options);
    }
}
