package khims.rodion.utils;

import khims.rodion.driver.SeleniumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LazyLoadElement {
    public static WebElement waitFor(long timeout, long polling, By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.getInstance())
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(polling))
                    .ignoring(NoSuchElementException.class);

            WebElement webElement = wait.until(driver -> driver.findElement(by));
            return webElement;
        } catch (Exception ex) {
            return null;
        }
    }
}
