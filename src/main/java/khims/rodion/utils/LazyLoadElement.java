package khims.rodion.utils;

import khims.rodion.driver.SeleniumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LazyLoadElement {
    public static WebElement waitFor(long timeout, long polling, By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.getInstance())
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(polling))
                    .ignoring(NoSuchElementException.class);

            return wait.until(driver -> driver.findElement(by));
        } catch (Exception ex) {
            return null;
        }
    }

    public static WebElement waitForClickable(long timeout, long polling, By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.getInstance())
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(polling))
                    .ignoring(NoSuchElementException.class);

            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception ex) {
            return null;
        }
    }
}
