package khims.rodion.page;

import khims.rodion.utils.LazyLoadElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BePaidAppForm {
    public WebElement getForm() {
        return LazyLoadElement.waitFor(10, 2, By.xpath("//div[@class='bepaid-app']"));
    }
}
