package khims.rodion.utils;

import khims.rodion.driver.SeleniumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LazyLoadElement {
    public static WebElement waitFor(long timeout, long polling, By by) {
        return waitUntil(timeout, polling, (driver) -> driver.findElement(by));
    }

    public static WebElement waitForClickable(long timeout, long polling, By by) {
        return waitUntil(timeout, polling, ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitForPresent(long timeout, long polling, By by) {
        return waitUntil(timeout, polling, ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebDriver waitForIFrame(long timeout, long polling, By by) {
        Wait<WebDriver> wait = createWait(timeout, polling);
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public static WebElement waitUntil(long timeout, long polling, ExpectedCondition<WebElement> condition) {
        try {
            Wait<WebDriver> wait = createWait(timeout, polling);
            return wait.until(condition);
        } catch (Exception ex) {
            return null;
        }
    }

    private static Wait<WebDriver> createWait(long timeout, long polling) {
        return new FluentWait<>(SeleniumDriver.getInstance())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class);
    }
}
