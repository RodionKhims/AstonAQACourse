package khims.rodion.page;

import khims.rodion.utils.LazyLoadElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CookieAgreementForm {
    public WebElement getCookieForm() {
        return LazyLoadElement.waitFor(120, 5, By.xpath("//div[contains(@class,'cookie')]"));
    }

    public WebElement getAcceptButton() {
        return LazyLoadElement.waitFor(120, 5, By.id("cookie-agree"));
    }
}
