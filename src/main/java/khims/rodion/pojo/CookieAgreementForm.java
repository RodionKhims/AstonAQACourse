package khims.rodion.pojo;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CookieAgreementForm {
    @FindBy(xpath = "//div[contains(@class,'cookie')]")
    private WebElement cookieForm;

    @FindBy(id = "cookie-agree")
    private WebElement acceptButton;
}
