package khims.rodion.page;

import khims.rodion.utils.LazyLoadElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CookieAgreementForm {
    public WebElement getAcceptButton() {
        return LazyLoadElement.waitFor(15, 3, By.id("cookie-agree"));
    }
}
