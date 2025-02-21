package khims.rodion.annotation;

import khims.rodion.utils.LazyLoadElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class PageElementResolver {
    public static void resolve(WebDriver driver, Object page) {
        Class<?> pageClass = page.getClass();
        Arrays.stream(pageClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(LazyFind.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    LazyFind annotation = field.getAnnotation(LazyFind.class);
                    try {
                        field.set(page, resolveElement(annotation));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static WebElement resolveElement(LazyFind params) {
        switch (params.waitType()) {
            case WAITFOR:
                return LazyLoadElement.waitFor(params.timeout(), params.period(), By.xpath(params.xpath()));
            case WAITFORCLICKABLE:
                return LazyLoadElement.waitForClickable(params.timeout(), params.period(), By.xpath(params.xpath()));
            case WAITFORPRESENT:
                return LazyLoadElement.waitForPresent(params.timeout(), params.period(), By.xpath(params.xpath()));
            default:
                throw new UnsupportedOperationException(params.waitType().toString());
        }
    }
}
